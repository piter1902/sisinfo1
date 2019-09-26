-- This is the script to create the tables of the data model of TRAFAIR project

CREATE DATABASE trafair;
CREATE EXTENSION IF NOT EXISTS timescaledb WITH SCHEMA public;
CREATE EXTENSION IF NOT EXISTS postgis WITH SCHEMA public;



drop table if exists system_properties;

drop table if exists road_node_turn_restriction;
drop table if exists road_segment_traffic_flow;
drop table if exists road_segment;
drop table if exists road_section;
drop table if exists road_node;

drop table if exists sensor_traffic_observation;
drop table if exists sensor_traffic;

drop table if exists road;

drop table if exists sensor_calibrated_observation;
drop table if exists sensor_calibration;
drop table if exists sensor_calibration_algorithm;
drop table if exists sensor_raw_observation;
drop table if exists sensor_low_cost_feature;
drop table if exists sensor_low_cost;

drop table if exists aq_legal_station_observation_not_validated;
drop table if exists aq_legal_station_observation_validated;
drop table if exists aq_legal_station_particles_not_validated;
drop table if exists aq_legal_station_particles_validated;
drop table if exists aq_legal_station;

drop table if exists weather_forecast;

drop table if exists building_shape;

drop table if exists vehicle_fleet;
drop table if exists vehicle;

drop table if exists emission_factor;

drop type if exists fuel;
drop type if exists osm_vehicle_type;
drop type if exists vehicle_type;
drop type if exists emission_standard;
drop type if exists technology;
drop type if exists pollutant;



--
--
--
-- VERSION
--
--
--
CREATE TABLE system_properties (
    id varchar(255) PRIMARY KEY,
    value varchar(255),
	description varchar(255)
);
-- example: INSERT INTO system_properties VALUES ('db_version', '0.1', 'database version');



--
--
--
-- ROAD NETWORK
--
--
--
CREATE TABLE road_node (
    id bigint PRIMARY KEY,                          -- id of the node in OpenStreetMap
    geom Geometry('POINT', 4326) NOT NULL,          -- a pair of latitude and longitude
    traffic_light boolean
);

CREATE TABLE road (
    name varchar(255) PRIMARY KEY
);

CREATE TABLE road_section (
    id bigint PRIMARY KEY,            -- id of the way in OpenStreetMap
    speed_limit int NOT NULL,         -- in km/h
    oneway boolean DEFAULT 'false',
    num_lanes int,
    type varchar(255) NOT NULL,
    name_road varchar(255),
    geom Geometry('LINESTRING', 4326) NOT NULL,
    width integer,
    CONSTRAINT road_section_FK FOREIGN KEY (name_road) REFERENCES road(name)
);

CREATE TABLE road_segment (
    segment_number int,
    node_start bigint NOT NULL,
    node_end bigint NOT NULL,
    id_road_section bigint NOT NULL,
	CONSTRAINT road_segment_PK PRIMARY KEY (id_road_section, segment_number),
    CONSTRAINT segment_FK1 FOREIGN KEY (node_start) REFERENCES road_node(id),
    CONSTRAINT segment_FK2 FOREIGN KEY (node_end) REFERENCES road_node(id),
    CONSTRAINT segment_FK3 FOREIGN KEY (id_road_section) REFERENCES road_section(id)
);


--------------
-----------
--------
-- CREATE TABLE road_segment_traffic_flow (
--     id_road_section bigint,
--     segment_number_road_segment int,
--     datetime TIMESTAMP,
--     flow int NOT NULL,                             -- number of vehicles
--     speed float CHECK (speed >= 0),                -- in km/h
--     CONSTRAINT road_segment_traffic_flow_PK PRIMARY KEY(id_road_section, segment_number_road_segment, datetime),
--     CONSTRAINT traffic_feature_FK FOREIGN KEY (id_road_section, segment_number_road_segment) REFERENCES road_segment(id_road_section, segment_number)
-- );
--------
-----------
--------------

-- ONLY IN MODENA
-- CREATE TABLE traffic_flow (
    -- id_road_section bigint,
    -- from_node bigint,
    -- to_node bigint,
    -- datetime TIMESTAMP,
    -- flow int NOT NULL,                             -- number of vehicles
    -- speed float CHECK (speed >= 0),                -- in km/h
    -- CONSTRAINT road_segment_traffic_flow_PK PRIMARY KEY(from_node, to_node, datetime),
    -- CONSTRAINT traffic_feature_FK1 FOREIGN KEY (id_road_section) REFERENCES road_section(id),
    -- CONSTRAINT traffic_feature_FK2 FOREIGN KEY (from_node) REFERENCES road_node(id),
    -- CONSTRAINT traffic_feature_FK3 FOREIGN KEY (to_node) REFERENCES road_node(id)
-- );
-- SELECT create_hypertable('traffic_flow', 'datetime');
-- SELECT set_chunk_time_interval('traffic_flow', interval '1 month');

CREATE TYPE osm_vehicle_type AS ENUM ('unknown', 'all', 'hgv', 'caravan', 'motorcar', 'bus', 'agricultural', 'motorcycle', 'bicycle', 'hazmat'); -- these are all the possible values of the vehicle_type for the restrictions in OpenStreetMap

CREATE TABLE road_node_turn_restriction (
    id serial PRIMARY KEY,
    type varchar(255) NOT NULL,
    vehicle_type osm_vehicle_type DEFAULT 'all',
    id_road_node_via bigint,
    id_road_section_via bigint,
    id_road_section_from bigint NOT NULL,
    id_road_section_to bigint NOT NULL,
    CONSTRAINT road_turn_restriction_FK1 FOREIGN KEY (id_road_node_via) REFERENCES road_node(id),
    CONSTRAINT road_turn_restriction_FK2 FOREIGN KEY (id_road_section_from) REFERENCES road_section(id),
    CONSTRAINT road_turn_restriction_FK3 FOREIGN KEY (id_road_section_to) REFERENCES road_section(id),
    CONSTRAINT road_turn_restriction_FK4 FOREIGN KEY (id_road_section_via) REFERENCES road_section(id)
);


--
--
--
-- TRAFFIC
--
--
--
CREATE TABLE sensor_traffic (
    id varchar(255) PRIMARY KEY,
    lane varchar(255),
    sensor_type varchar(255),
    geom Geometry('POINT', 4326) NOT NULL,
    direction boolean DEFAULT 'true',
    road_section bigint,
    num_segment int,
    nearest_node bigint,
    description text,
    CONSTRAINT sensor_traffic_FK1 FOREIGN KEY (road_section, num_segment) REFERENCES road_segment (id_road_section, segment_number),
    CONSTRAINT sensor_traffic_FK2 FOREIGN KEY (nearest_node) REFERENCES road_node(id)
);

CREATE TABLE sensor_traffic_observation (
    id_sensor_traffic varchar(255),
    datetime TIMESTAMP,
    vehicle_type varchar(255) DEFAULT 'unknown',
    speed float NOT NULL,                       -- in km/h
    flow int NOT NULL,
    occupancy float,                                              -- this attribute is not mandatory for the project, but if you have this information you can put it here
    CONSTRAINT traffic_observation_PK PRIMARY KEY (id_sensor_traffic, datetime, vehicle_type),
    CONSTRAINT traffic_observation_FK FOREIGN KEY (id_sensor_traffic) REFERENCES sensor_traffic(id)
);
SELECT create_hypertable('sensor_traffic_observation', 'datetime');
SELECT set_chunk_time_interval('sensor_traffic_observation', interval '1 month');



--
--
--
-- LOW-COST AIR QUALITY SENSOR
--
--
--
CREATE TABLE sensor_low_cost (
    id serial PRIMARY KEY,
    model varchar(255) NOT NULL,
    description varchar(255)
);

CREATE TABLE sensor_low_cost_feature (
    id serial PRIMARY KEY,
    geom Geometry('POINT', 4326) NOT NULL                 -- a pair of latitude and longitude
);

CREATE TABLE sensor_raw_observation (
    id_sensor_low_cost serial,
    phenomenon_time TIMESTAMP,
    id_sensor_low_cost_feature serial NOT NULL,
    battery_voltage float,
    humidity float NOT NULL,          -- percentage
    temperature float NOT NULL,         -- degree Celsius
    no_we float NOT NULL,             -- in mV
    no_aux float NOT NULL,            -- in mV
    no2_we float NOT NULL,            -- in mV
    no2_aux float NOT NULL,           -- in mV
    o3_we float NOT NULL,             -- in mV
    o3_aux float NOT NULL,            -- in mV
    co_we float NOT NULL,             -- in mV
    co_aux float NOT NULL,            -- in mV
    CONSTRAINT raw_observation_PK PRIMARY KEY (id_sensor_low_cost, phenomenon_time),
    CONSTRAINT raw_observation_FK1 FOREIGN KEY (id_sensor_low_cost) REFERENCES sensor_low_cost(id),
    CONSTRAINT raw_observation_FK2 FOREIGN KEY (id_sensor_low_cost_feature) REFERENCES sensor_low_cost_feature(id)
);
SELECT create_hypertable('sensor_raw_observation', 'phenomenon_time');
SELECT set_chunk_time_interval('sensor_raw_observation', interval '1 month');

CREATE TABLE sensor_calibration_algorithm (
    id serial PRIMARY KEY,
    model_name varchar(255) NOT NULL,
    hyper_parameters varchar(255) NOT NULL,
    training_start TIMESTAMP NOT NULL,
    training_end TIMESTAMP NOT NULL,
    regression_variables varchar(255) NOT NULL,
    note text,
    python_library varchar(255) NOT NULL
);

CREATE TABLE sensor_calibration (
    id serial PRIMARY KEY,
    sensor_calibration_algorithm_co serial NOT NULL,
    sensor_calibration_algorithm_no serial NOT NULL,
    sensor_calibration_algorithm_no2 serial NOT NULL,
    sensor_calibration_algorithm_o3 serial NOT NULL,
    CONSTRAINT sensor_calibration_FK1 FOREIGN KEY (sensor_calibration_algorithm_co) REFERENCES sensor_calibration_algorithm(id),
    CONSTRAINT sensor_calibration_FK2 FOREIGN KEY (sensor_calibration_algorithm_no) REFERENCES sensor_calibration_algorithm(id),
    CONSTRAINT sensor_calibration_FK3 FOREIGN KEY (sensor_calibration_algorithm_no2) REFERENCES sensor_calibration_algorithm(id),
    CONSTRAINT sensor_calibration_FK4 FOREIGN KEY (sensor_calibration_algorithm_o3) REFERENCES sensor_calibration_algorithm(id)
);

CREATE TABLE sensor_calibrated_observation (
    id_sensor_calibration serial,
    phenomenon_time TIMESTAMP,
    result_time TIMESTAMP,
    no int NOT NULL,             -- probably in ug/m3
    no2 int NOT NULL,            -- probably in ug/m3
    co int NOT NULL,             -- probably in ug/m3
    o3 int NOT NULL,             -- probably in ug/m3
    id_sensor_low_cost_feature serial NOT NULL,
    CONSTRAINT calibrated_observation_PK PRIMARY KEY (id_sensor_calibration, phenomenon_time),
    CONSTRAINT calibrated_observation_FK1 FOREIGN KEY (id_sensor_calibration) REFERENCES sensor_calibration(id),
    CONSTRAINT calibrated_observation_FK2 FOREIGN KEY (id_sensor_low_cost_feature) REFERENCES sensor_low_cost_feature(id)
);
SELECT create_hypertable('sensor_calibrated_observation', 'phenomenon_time');
SELECT set_chunk_time_interval('sensor_calibrated_observation', interval '1 month');



--
--
--
-- AIR QUALITY LEGAL STATION
--
--
--
CREATE TABLE aq_legal_station (
    id serial PRIMARY KEY,
    name varchar(255) NOT NULL,
    description text,
    geom Geometry('POINT', 4326) NOT NULL,
    height float
);

CREATE TABLE aq_legal_station_observation_not_validated (
    phenomenon_time TIMESTAMP,              -- timestamp to which the observation is related
    id_aq_legal_station serial,
    c6h6 float,                             -- probably in ug/m3
    co float,                               -- probably in ug/m3
    no float,                               -- probably in ug/m3
    no2 float,                              -- probably in ug/m3
    o3 float,                               -- probably in ug/m3
    nox integer,                            -- probably in ug/m3
    CONSTRAINT aqls_observation_not_validated_PK PRIMARY KEY (phenomenon_time, id_aq_legal_station),
    CONSTRAINT aqls_observation_not_validated_FK FOREIGN KEY (id_aq_legal_station) REFERENCES aq_legal_station(id)
);
SELECT create_hypertable('aq_legal_station_observation_not_validated', 'phenomenon_time');
SELECT set_chunk_time_interval('aq_legal_station_observation_not_validated', interval '1 month');

CREATE TABLE aq_legal_station_observation_validated (
    phenomenon_time TIMESTAMP,              -- timestamp to which the observation is related
    id_aq_legal_station serial,
    c6h6 float,                             -- probably in ug/m3
    co float,                               -- probably in ug/m3
    no float,                               -- probably in ug/m3
    no2 float,                              -- probably in ug/m3
    o3 float,                               -- probably in ug/m3
    result_time TIMESTAMP,                  -- timestamp of the validation
    CONSTRAINT aqls_observation_validated_PK PRIMARY KEY (phenomenon_time, id_aq_legal_station),
    CONSTRAINT aqls_observation_validated_FK FOREIGN KEY (id_aq_legal_station) REFERENCES aq_legal_station(id)
);
SELECT create_hypertable('aq_legal_station_observation_validated', 'phenomenon_time');
SELECT set_chunk_time_interval('aq_legal_station_observation_validated', interval '1 month');

CREATE TABLE aq_legal_station_particles_validated (
    phenomenon_time TIMESTAMP,            -- timestamp to which the observation is related
    id_aq_legal_station serial,
    pm10 float,
    pm25 float,
    result_time TIMESTAMP,                -- timestamp of the validation
    CONSTRAINT aqls_particles_validated_PK PRIMARY KEY (phenomenon_time, id_aq_legal_station),
    CONSTRAINT aqls_particles_validated_FK FOREIGN KEY (id_aq_legal_station) REFERENCES aq_legal_station(id)
);
SELECT create_hypertable('aq_legal_station_particles_validated', 'phenomenon_time');
SELECT set_chunk_time_interval('aq_legal_station_particles_validated', interval '1 month');



--
--
--
-- WEATHER FORECAST
--
--
--
CREATE TABLE weather_forecast (
    id integer NOT NULL PRIMARY KEY,
    forecast_time TIMESTAMP NOT NULL,      -- date and time to which the forecast is related
    result_time TIMESTAMP NOT NULL,        -- when the forecast is done
    geom public.geometry(Point,4326) NOT NULL,
    height_h1 double precision DEFAULT 2,
    height_h2 double precision DEFAULT 10,
    height_h3 double precision,
    height_h4 double precision,
    height_h5 double precision,
    height_h6 double precision,
    height_h7 double precision,
    wind_speed_h1 double precision,
    wind_speed_h2 double precision,
    wind_speed_h3 double precision,
    wind_speed_h4 double precision,
    wind_speed_h5 double precision,
    wind_speed_h6 double precision,
    wind_speed_h7 double precision,
    wind_direction_h1 double precision,        -- the value 0 indicates nord, 90 indicates east, 180 indicates sud, 270 indicates west, and so on
    wind_direction_h2 double precision,
    wind_direction_h3 double precision,
    wind_direction_h4 double precision,
    wind_direction_h5 double precision,
    wind_direction_h6 double precision,
    wind_direction_h7 double precision,
    temperature_h1 double precision,
    temperature_h2 double precision,
    temperature_h3 double precision,
    temperature_h4 double precision,
    temperature_h5 double precision,
    temperature_h6 double precision,
    temperature_h7 double precision,
    vertical_wind_speed_h1 double precision,
    vertical_wind_speed_h2 double precision,
    vertical_wind_speed_h3 double precision,
    vertical_wind_speed_h4 double precision,
    vertical_wind_speed_h5 double precision,
    vertical_wind_speed_h6 double precision,
    vertical_wind_speed_h7 double precision,
    monin_obukhov_length double precision,
    surface_friction_velocity double precision,
    planetary_boundary_layer_height integer,
    roughness_length double precision,
    convective_scale_velocity double precision,
    stability_class smallint
);


--
--
--
-- 3D SHAPE OF THE BUILDINGS
--
--
--
CREATE TABLE building_shape (
    id serial PRIMARY KEY,
    height int NOT NULL CHECK (height > 0),                -- in meters
    pol Geometry('POLYGON', 4326) NOT NULL                 -- a set of points explained using latitude and longitude
);


CREATE TYPE fuel AS ENUM ('biodiesel', 'cng', 'cng_bifuel', 'cng_bifuel_petrol', 'diesel', 'lpg_bifuel', 'lpg_bifuel_petrol', 'petrol', 'petrol_hybrid', 'lpg', 'diesel_hybrid');
CREATE TYPE vehicle_type AS ENUM ('bus', 'heavy_duty_truck', 'passenger_car', 'l-category', 'light_commercial_vehicle', 'micro_car', 'moped', 'motorcycle', 'quad_ATV');
CREATE TYPE emission_standard AS ENUM ('conventional', 'ece 15/00-01', 'ece 15/02', 'ece 15/03', 'ece 15/04', 'eev', 'euro 1', 'euro 2', 'euro 3', 'euro 4', 'euro 5', 'euro 6', 'euro 6 2017-2019', 'euro 6 2018-2020', 'euro 6 2020+', 'euro 6 2021+', 'euro 6 up to 2016', 'euro 6 up to 2017', 'improved conventional', 'open loop', 'pre ece');
CREATE TYPE technology AS ENUM ('dpf', 'dpf+scr', 'egr', 'gdi', 'gdi+gpf', 'lnt+dpf', 'pfi', 'scr');
CREATE TYPE public.emission_factor_vehicle_type AS ENUM ('bus','heavy_duty_truck','passenger_car','l-category','light_commercial_vehicle');
--
--
--
-- VEHICLE FLEET COMPOSITION
--
--
--
CREATE TABLE vehicle (
    id serial PRIMARY KEY,
    engine_size float,                                  -- in litres
    fuel fuel NOT NULL,
    class vehicle_type NOT NULL,
    technology technology,
    engine_description character varying,
    emission_standard emission_standard NOT NULL,
    load float,
    registration_year smallint,
    wheels_number smallint,
    motor_type character varying,
    number float NOT NULL
);

CREATE TABLE vehicle_fleet(
    id_vehicle serial,
    road_type varchar(255) NOT NULL,    
    vehicles_percentage real NOT NULL CHECK (vehicles_percentage >= 0),
    road_slope double precision,
    CONSTRAINT fleet_PK PRIMARY KEY (road_type, id_vehicle),
    CONSTRAINT fleet_FK FOREIGN KEY (id_vehicle) REFERENCES vehicle(id)
);


CREATE TYPE pollutant AS ENUM ('co', 'nox');

CREATE TABLE pollutants (
    id_measure int NOT NULL PRIMARY KEY,
    phenomenon_time TIMESTAMP NOT NULL,
    pollutant varchar(255),
    value double precision NOT NULL,
    road_section_id bigint NOT NULL,
    CONSTRAINT read_section_fk1 FOREIGN KEY (road_section_id) REFERENCES road_section(id)
);

--
--
--
-- EMISSION FACTORS FOR VEHICLES
--
--
--
CREATE TABLE emission_factor (
    id serial PRIMARY KEY,
    vehicle_type vehicle_type NOT NULL,
    fuel fuel NOT NULL,
    segment varchar(255) NOT NULL,
    emission_standard emission_standard NOT NULL,
    technology technology,    
    pollutant pollutant NOT NULL,
    min_speed int NOT NULL CHECK (min_speed >= 0),
    max_speed int NOT NULL CHECK (max_speed > 0),
    alpha float NOT NULL,
    beta float NOT NULL,
    gamma float NOT NULL,
    delta float NOT NULL,
    epsilon float NOT NULL,
    zita float NOT NULL,
    hta float NOT NULL,
    reduction_factor float NOT NULL,
    emission_factor float NOT NULL
);
