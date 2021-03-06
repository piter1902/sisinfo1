!function(e) {
	if ("object" == typeof exports && "undefined" != typeof module) module.exports = e();
	else if ("function" == typeof define && define.amd) define([], e);
	else {
		("undefined" != typeof window ? window : "undefined" != typeof global ? global : "undefined" != typeof self ? self : this).leafletControlGeocoder = e()
	}
}(function() {
	return function e(t, o, n) {
		function s(r, a) {
			if (!o[r]) {
				if (!t[r]) {
					var l = "function" == typeof require && require;
					if (!a && l) return l(r, !0);
					if (i) return i(r, !0);
					var c = new Error("Cannot find module '" + r + "'");
					throw c.code = "MODULE_NOT_FOUND", c
				}
				var d = o[r] = {
					exports: {}
				};
				
				t[r][0].call(d.exports, function(e) {
					var o = t[r][1][e];
					return s(o || e)
				}, d, d.exports, e, t, o, n)
			}
			return o[r].exports
		}
		for (var i = "function" == typeof require && require, r = 0; r < n.length; r++) s(n[r]);
		return s
	}({
		1: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("./geocoders/nominatim").class;
				t.exports = {
					class: n.Control.extend({
						options: {
							showResultIcons: !1,
							collapsed: !0,
							expand: "click",
							position: "topright",
							placeholder: "Search...",
							errorMessage: "Nothing found.",
							suggestMinLength: 3,
							suggestTimeout: 250,
							defaultMarkGeocode: !0
						},
						
						includes: n.Mixin.Events,
						initialize: function(e) {
							n.Util.setOptions(this, e), this.options.geocoder || (this.options.geocoder = new s), this._requestCount = 0
						},
						
						onAdd: function(e) {
							var t, o = "leaflet-control-geocoder",
								s = n.DomUtil.create("div", o + " leaflet-bar"),
								i = n.DomUtil.create("button", o + "-icon", s),
								r = this._form = n.DomUtil.create("div", o + "-form", s);
							return this._map = e, this._container = s, i.innerHTML = "&nbsp;", i.type = "button", t = this._input = n.DomUtil.create("input", "", r), t.type = "text", t.placeholder = this.options.placeholder, this._errorElement = n.DomUtil.create("div", o + "-form-no-error", s), this._errorElement.innerHTML = this.options.errorMessage, this._alts = n.DomUtil.create("ul", o + "-alternatives leaflet-control-geocoder-alternatives-minimized", s), n.DomEvent.disableClickPropagation(this._alts), n.DomEvent.addListener(t, "keydown", this._keydown, this), n.DomEvent.addListener(t, "blur", function() {
								this.options.collapsed && !this._preventBlurCollapse && this._collapse(), this._preventBlurCollapse = !1
							}, this), this.options.collapsed ? "click" === this.options.expand ? n.DomEvent.addListener(i, "click", function(e) {
								0 === e.button && 2 !== e.detail && this._toggle()
							}, this) : (n.DomEvent.addListener(i, "mouseover", this._expand, this), n.DomEvent.addListener(i, "mouseout", this._collapse, this), this._map.on("movestart", this._collapse, this)) : (n.DomEvent.addListener(i, "click", function(e) {
								this._geocode(e)
							}, this), this._expand()), this.options.defaultMarkGeocode && this.on("markgeocode", this.markGeocode, this), this.on("startgeocode", function() {
								n.DomUtil.addClass(this._container, "leaflet-control-geocoder-throbber")
							}, this), this.on("finishgeocode", function() {
								n.DomUtil.removeClass(this._container, "leaflet-control-geocoder-throbber")
							}, this), n.DomEvent.disableClickPropagation(s), s
						},
						
						_geocodeResult: function(e, t) {
							if (t || 1 !== e.length) if (e.length > 0) {
								this._alts.innerHTML = "", this._results = e, n.DomUtil.removeClass(this._alts, "leaflet-control-geocoder-alternatives-minimized");
								for (var o = 0; o < e.length; o++) this._alts.appendChild(this._createAlt(e[o], o))
							} else n.DomUtil.addClass(this._errorElement, "leaflet-control-geocoder-error");
							else this._geocodeResultSelected(e[0])
						},
						
						markGeocode: function(e) {
							return e = e.geocode || e, this._map.fitBounds(e.bbox), this._geocodeMarker && this._map.removeLayer(this._geocodeMarker), this._geocodeMarker = new n.Marker(e.center).bindPopup(e.html || e.name).addTo(this._map).openPopup(), this
						},
						
						_geocode: function(e) {
							var t = ++this._requestCount,
								o = e ? "suggest" : "geocode",
								n = {
									input: this._input.value
								};
							
							this._lastGeocode = this._input.value, e || this._clearResults(), this.fire("start" + o, n), this.options.geocoder[o](this._input.value, function(s) {
								t === this._requestCount && (n.results = s, this.fire("finish" + o, n), this._geocodeResult(s, e))
							}, this)
						},
						
						_geocodeResultSelected: function(e) {
							this.options.collapsed || this._clearResults(), this.fire("markgeocode", {
								geocode: e
							})
						},
						
						_toggle: function() {
							this._container.className.indexOf("leaflet-control-geocoder-expanded") >= 0 ? this._collapse() : this._expand()
						},
						
						_expand: function() {
							n.DomUtil.addClass(this._container, "leaflet-control-geocoder-expanded"), this._input.select(), this.fire("expand")
						},
						
						_collapse: function() {
							this._container.className = this._container.className.replace(" leaflet-control-geocoder-expanded", ""), n.DomUtil.addClass(this._alts, "leaflet-control-geocoder-alternatives-minimized"), n.DomUtil.removeClass(this._errorElement, "leaflet-control-geocoder-error"), this.fire("collapse")
						},
						
						_clearResults: function() {
							n.DomUtil.addClass(this._alts, "leaflet-control-geocoder-alternatives-minimized"), this._selection = null, n.DomUtil.removeClass(this._errorElement, "leaflet-control-geocoder-error")
						},
						
						_createAlt: function(e, t) {
							var o = n.DomUtil.create("li", ""),
								s = n.DomUtil.create("a", "", o),
								i = this.options.showResultIcons && e.icon ? n.DomUtil.create("img", "", s) : null,
								r = e.html ? void 0 : document.createTextNode(e.name);
							return i && (i.src = e.icon), o.setAttribute("data-result-index", t), e.html ? s.innerHTML = s.innerHTML + e.html : s.appendChild(r), n.DomEvent.addListener(o, "mousedown", function(t) {
								this._preventBlurCollapse = !0, n.DomEvent.stop(t), this._geocodeResultSelected(e), n.DomEvent.on(o, "click", function() {
									this.options.collapsed && this._collapse()
								}, this)
							}, this), o
						},
						
						_keydown: function(e) {
							var t = this,
								o = function(e) {
									t._selection && (n.DomUtil.removeClass(t._selection, "leaflet-control-geocoder-selected"), t._selection = t._selection[e > 0 ? "nextSibling" : "previousSibling"]), t._selection || (t._selection = t._alts[e > 0 ? "firstChild" : "lastChild"]), t._selection && n.DomUtil.addClass(t._selection, "leaflet-control-geocoder-selected")
								};
							
							switch (e.keyCode) {
								case 27:
									this.options.collapsed && this._collapse();
									
									break;
								case 38:
									o(-1), n.DomEvent.preventDefault(e);
									break;
								case 40:
									o(1), n.DomEvent.preventDefault(e);
									break;
								case 13:
									if (this._selection) {
										var s = parseInt(this._selection.getAttribute("data-result-index"), 10);
										this._geocodeResultSelected(this._results[s]), this._clearResults()
									} else this._geocode();
									
									n.DomEvent.preventDefault(e);
									break;
								default:
									var i = this._input.value;
									this.options.geocoder.suggest && i !== this._lastGeocode && (clearTimeout(this._suggestTimeout), i.length >= this.options.suggestMinLength ? this._suggestTimeout = setTimeout(n.bind(function() {
										this._geocode(!0)
									}, this), this.options.suggestTimeout) : this._clearResults())
							}
						}
					}),
					factory: function(e) {
						return new n.Control.Geocoder(e)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"./geocoders/nominatim": 9
		}],
		2: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						options: {
							service_url: "http://geocode.arcgis.com/arcgis/rest/services/World/GeocodeServer"
						},
						
						initialize: function(e, t) {
							n.setOptions(this, t), this._accessToken = e
						},
						
						geocode: function(e, t, o) {
							var i = {
								SingleLine: e,
								outFields: "Addr_Type",
								forStorage: !1,
								maxLocations: 10,
								f: "json"
							};
							
							this._key && this._key.length && (i.token = this._key), s.getJSON(this.options.service_url + "/findAddressCandidates", i, function(e) {
								var s, i, r, a = [];
								if (e.candidates && e.candidates.length) for (var l = 0; l <= e.candidates.length - 1; l++) s = e.candidates[l], i = n.latLng(s.location.y, s.location.x), r = n.latLngBounds(n.latLng(s.extent.ymax, s.extent.xmax), n.latLng(s.extent.ymin, s.extent.xmin)), a[l] = {
									name: s.address,
									bbox: r,
									center: i
								};
								
								t.call(o, a)
							})
						},
						
						suggest: function(e, t, o) {
							return this.geocode(e, t, o)
						},
						
						reverse: function(e, t, o, i) {
							var r = {
								location: encodeURIComponent(e.lng) + "," + encodeURIComponent(e.lat),
								distance: 100,
								f: "json"
							};
							
							s.getJSON(this.options.service_url + "/reverseGeocode", r, function(e) {
								var t, s = [];
								e && !e.error && (t = n.latLng(e.location.y, e.location.x), s.push({
									name: e.address.Match_addr,
									center: t,
									bounds: n.latLngBounds(t, t)
								})), o.call(i, s)
							})
						}
					}),
					factory: function(e, t) {
						return new n.Control.Geocoder.ArcGis(e, t)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		3: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						initialize: function(e) {
							this.key = e
						},
						
						geocode: function(e, t, o) {
							s.jsonp("https://dev.virtualearth.net/REST/v1/Locations", {
								query: e,
								key: this.key
							}, function(e) {
								var s = [];
								if (e.resourceSets.length > 0) for (var i = e.resourceSets[0].resources.length - 1; i >= 0; i--) {
									var r = e.resourceSets[0].resources[i],
										a = r.bbox;
									s[i] = {
										name: r.name,
										bbox: n.latLngBounds([a[0], a[1]], [a[2], a[3]]),
										center: n.latLng(r.point.coordinates)
									}
								}
								t.call(o, s)
							}, this, "jsonp")
						},
						
						reverse: function(e, t, o, i) {
							s.jsonp("//dev.virtualearth.net/REST/v1/Locations/" + e.lat + "," + e.lng, {
								key: this.key
							}, function(e) {
								for (var t = [], s = e.resourceSets[0].resources.length - 1; s >= 0; s--) {
									var r = e.resourceSets[0].resources[s],
										a = r.bbox;
									t[s] = {
										name: r.name,
										bbox: n.latLngBounds([a[0], a[1]], [a[2], a[3]]),
										center: n.latLng(r.point.coordinates)
									}
								}
								o.call(i, t)
							}, this, "jsonp")
						}
					}),
					factory: function(e) {
						return new n.Control.Geocoder.Bing(e)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		4: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						options: {
							serviceUrl: "https://maps.googleapis.com/maps/api/geocode/json",
							geocodingQueryParams: {},
							
							reverseQueryParams: {}
						},
						
						initialize: function(e, t) {
							this._key = e, n.setOptions(this, t), this.options.serviceUrl = this.options.service_url || this.options.serviceUrl
						},
						
						geocode: function(e, t, o) {
							var i = {
								address: e
							};
							
							this._key && this._key.length && (i.key = this._key), i = n.Util.extend(i, this.options.geocodingQueryParams), s.getJSON(this.options.serviceUrl, i, function(e) {
								var s, i, r, a = [];
								if (e.results && e.results.length) for (var l = 0; l <= e.results.length - 1; l++) s = e.results[l], i = n.latLng(s.geometry.location), r = n.latLngBounds(n.latLng(s.geometry.viewport.northeast), n.latLng(s.geometry.viewport.southwest)), a[l] = {
									name: s.formatted_address,
									bbox: r,
									center: i,
									properties: s.address_components
								};
								
								t.call(o, a)
							})
						},
						
						reverse: function(e, t, o, i) {
							var r = {
								latlng: encodeURIComponent(e.lat) + "," + encodeURIComponent(e.lng)
							};
							
							r = n.Util.extend(r, this.options.reverseQueryParams), this._key && this._key.length && (r.key = this._key), s.getJSON(this.options.serviceUrl, r, function(e) {
								var t, s, r, a = [];
								if (e.results && e.results.length) for (var l = 0; l <= e.results.length - 1; l++) t = e.results[l], s = n.latLng(t.geometry.location), r = n.latLngBounds(n.latLng(t.geometry.viewport.northeast), n.latLng(t.geometry.viewport.southwest)), a[l] = {
									name: t.formatted_address,
									bbox: r,
									center: s,
									properties: t.address_components
								};
								
								o.call(i, a)
							})
						}
					}),
					factory: function(e, t) {
						return new n.Control.Geocoder.Google(e, t)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		5: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						options: {
							geocodeUrl: "http://geocoder.api.here.com/6.2/geocode.json",
							reverseGeocodeUrl: "http://reverse.geocoder.api.here.com/6.2/reversegeocode.json",
							app_id: "<insert your app_id here>",
							app_code: "<insert your app_code here>",
							geocodingQueryParams: {},
							
							reverseQueryParams: {}
						},
						
						initialize: function(e) {
							n.setOptions(this, e)
						},
						
						geocode: function(e, t, o) {
							var s = {
								searchtext: e,
								gen: 9,
								app_id: this.options.app_id,
								app_code: this.options.app_code,
								jsonattributes: 1
							};
							
							s = n.Util.extend(s, this.options.geocodingQueryParams), this.getJSON(this.options.geocodeUrl, s, t, o)
						},
						
						reverse: function(e, t, o, s) {
							var i = {
								prox: encodeURIComponent(e.lat) + "," + encodeURIComponent(e.lng),
								mode: "retrieveAddresses",
								app_id: this.options.app_id,
								app_code: this.options.app_code,
								gen: 9,
								jsonattributes: 1
							};
							
							i = n.Util.extend(i, this.options.reverseQueryParams), this.getJSON(this.options.reverseGeocodeUrl, i, o, s)
						},
						
						getJSON: function(e, t, o, i) {
							s.getJSON(e, t, function(e) {
								var t, s, r, a = [];
								if (e.response.view && e.response.view.length) for (var l = 0; l <= e.response.view[0].result.length - 1; l++) t = e.response.view[0].result[l].location, s = n.latLng(t.displayPosition.latitude, t.displayPosition.longitude), r = n.latLngBounds(n.latLng(t.mapView.topLeft.latitude, t.mapView.topLeft.longitude), n.latLng(t.mapView.bottomRight.latitude, t.mapView.bottomRight.longitude)), a[l] = {
									name: t.address.label,
									bbox: r,
									center: s
								};
								
								o.call(i, a)
							})
						}
					}),
					factory: function(e) {
						return new n.Control.Geocoder.HERE(e)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		6: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						options: {
							serviceUrl: "https://api.tiles.mapbox.com/v4/geocode/mapbox.places-v1/",
							geocodingQueryParams: {},
							
							reverseQueryParams: {}
						},
						
						initialize: function(e, t) {
							n.setOptions(this, t), this.options.geocodingQueryParams.access_token = e, this.options.reverseQueryParams.access_token = e
						},
						
						geocode: function(e, t, o) {
							var i = this.options.geocodingQueryParams;
							void 0 !== i.proximity && i.proximity.hasOwnProperty("lat") && i.proximity.hasOwnProperty("lng") && (i.proximity = i.proximity.lng + "," + i.proximity.lat), s.getJSON(this.options.serviceUrl + encodeURIComponent(e) + ".json", i, function(e) {
								var s, i, r, a = [];
								if (e.features && e.features.length) for (var l = 0; l <= e.features.length - 1; l++) s = e.features[l], i = n.latLng(s.center.reverse()), r = s.hasOwnProperty("bbox") ? n.latLngBounds(n.latLng(s.bbox.slice(0, 2).reverse()), n.latLng(s.bbox.slice(2, 4).reverse())) : n.latLngBounds(i, i), a[l] = {
									name: s.place_name,
									bbox: r,
									center: i
								};
								
								t.call(o, a)
							})
						},
						
						suggest: function(e, t, o) {
							return this.geocode(e, t, o)
						},
						
						reverse: function(e, t, o, i) {
							s.getJSON(this.options.serviceUrl + encodeURIComponent(e.lng) + "," + encodeURIComponent(e.lat) + ".json", this.options.reverseQueryParams, function(e) {
								var t, s, r, a = [];
								if (e.features && e.features.length) for (var l = 0; l <= e.features.length - 1; l++) t = e.features[l], s = n.latLng(t.center.reverse()), r = t.hasOwnProperty("bbox") ? n.latLngBounds(n.latLng(t.bbox.slice(0, 2).reverse()), n.latLng(t.bbox.slice(2, 4).reverse())) : n.latLngBounds(s, s), a[l] = {
									name: t.place_name,
									bbox: r,
									center: s
								};
								
								o.call(i, a)
							})
						}
					}),
					factory: function(e, t) {
						return new n.Control.Geocoder.Mapbox(e, t)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		7: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						options: {
							serviceUrl: "https://www.mapquestapi.com/geocoding/v1"
						},
						
						initialize: function(e, t) {
							this._key = decodeURIComponent(e), n.Util.setOptions(this, t)
						},
						
						_formatName: function() {
							var e, t = [];
							for (e = 0; e < arguments.length; e++) arguments[e] && t.push(arguments[e]);
							return t.join(", ")
						},
						
						geocode: function(e, t, o) {
							s.jsonp(this.options.serviceUrl + "/address", {
								key: this._key,
								location: e,
								limit: 5,
								outFormat: "json"
							}, function(e) {
								var s, i, r = [];
								if (e.results && e.results[0].locations) for (var a = e.results[0].locations.length - 1; a >= 0; a--) s = e.results[0].locations[a], i = n.latLng(s.latLng), r[a] = {
									name: this._formatName(s.street, s.adminArea4, s.adminArea3, s.adminArea1),
									bbox: n.latLngBounds(i, i),
									center: i
								};
								
								t.call(o, r)
							}, this)
						},
						
						reverse: function(e, t, o, i) {
							s.jsonp(this.options.serviceUrl + "/reverse", {
								key: this._key,
								location: e.lat + "," + e.lng,
								outputFormat: "json"
							}, function(e) {
								var t, s, r = [];
								if (e.results && e.results[0].locations) for (var a = e.results[0].locations.length - 1; a >= 0; a--) t = e.results[0].locations[a], s = n.latLng(t.latLng), r[a] = {
									name: this._formatName(t.street, t.adminArea4, t.adminArea3, t.adminArea1),
									bbox: n.latLngBounds(s, s),
									center: s
								};
								
								o.call(i, r)
							}, this)
						}
					}),
					factory: function(e, t) {
						return new n.Control.Geocoder.MapQuest(e, t)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		8: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						options: {
							serviceUrl: "https://search.mapzen.com/v1",
							geocodingQueryParams: {},
							
							reverseQueryParams: {}
						},
						
						initialize: function(e, t) {
							n.Util.setOptions(this, t), this._apiKey = e, this._lastSuggest = 0
						},
						
						geocode: function(e, t, o) {
							var i = this;
							s.getJSON(this.options.serviceUrl + "/search", n.extend({
								api_key: this._apiKey,
								text: e
							}, this.options.geocodingQueryParams), function(e) {
								t.call(o, i._parseResults(e, "bbox"))
							})
						},
						
						suggest: function(e, t, o) {
							var i = this;
							s.getJSON(this.options.serviceUrl + "/autocomplete", n.extend({
								api_key: this._apiKey,
								text: e
							}, this.options.geocodingQueryParams), n.bind(function(e) {
								e.geocoding.timestamp > this._lastSuggest && (this._lastSuggest = e.geocoding.timestamp, t.call(o, i._parseResults(e, "bbox")))
							}, this))
						},
						
						reverse: function(e, t, o, i) {
							var r = this;
							s.getJSON(this.options.serviceUrl + "/reverse", n.extend({
								api_key: this._apiKey,
								"point.lat": e.lat,
								"point.lon": e.lng
							}, this.options.reverseQueryParams), function(e) {
								o.call(i, r._parseResults(e, "bounds"))
							})
						},
						
						_parseResults: function(e, t) {
							var o = [];
							return n.geoJson(e, {
								pointToLayer: function(e, t) {
									return n.circleMarker(t)
								},
								
								onEachFeature: function(e, s) {
									var i, r, a = {};
									
									s.getBounds ? r = (i = s.getBounds()).getCenter() : (r = s.getLatLng(), i = n.latLngBounds(r, r)), a.name = s.feature.properties.label, a.center = r, a[t] = i, a.properties = s.feature.properties, o.push(a)
								}
							}), o
						}
					}),
					factory: function(e, t) {
						return new n.Control.Geocoder.Mapzen(e, t)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		9: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						options: {
							serviceUrl: "https://nominatim.openstreetmap.org/",
							geocodingQueryParams: {},
							
							reverseQueryParams: {},
							
							htmlTemplate: function(e) {
								var t = e.address,
									o = [];
								return (t.road || t.building) && o.push("{building} {road} {house_number}"), (t.city || t.town || t.village || t.hamlet) && o.push('<span class="' + (o.length > 0 ? "leaflet-control-geocoder-address-detail" : "") + '">{postcode} {city} {town} {village} {hamlet}</span>'), (t.state || t.country) && o.push('<span class="' + (o.length > 0 ? "leaflet-control-geocoder-address-context" : "") + '">{state} {country}</span>'), s.template(o.join("<br/>"), t, !0)
							}
						},
						
						initialize: function(e) {
							n.Util.setOptions(this, e)
						},
						
						geocode: function(e, t, o) {
							s.jsonp(this.options.serviceUrl + "search", n.extend({
								q: e,
								limit: 5,
								format: "json",
								addressdetails: 1
							}, this.options.geocodingQueryParams), function(e) {
								for (var s = [], i = e.length - 1; i >= 0; i--) {
									for (var r = e[i].boundingbox, a = 0; a < 4; a++) r[a] = parseFloat(r[a]);
									s[i] = {
										icon: e[i].icon,
										name: e[i].display_name,
										html: this.options.htmlTemplate ? this.options.htmlTemplate(e[i]) : void 0,
										bbox: n.latLngBounds([r[0], r[2]], [r[1], r[3]]),
										center: n.latLng(e[i].lat, e[i].lon),
										properties: e[i]
									}
								}
								t.call(o, s)
							}, this, "json_callback")
						},
						
						reverse: function(e, t, o, i) {
							s.jsonp(this.options.serviceUrl + "reverse", n.extend({
								lat: e.lat,
								lon: e.lng,
								zoom: Math.round(Math.log(t / 256) / Math.log(2)),
								addressdetails: 1,
								format: "json"
							}, this.options.reverseQueryParams), function(e) {
								var t, s = [];
								e && e.lat && e.lon && (t = n.latLng(e.lat, e.lon), s.push({
									name: e.display_name,
									html: this.options.htmlTemplate ? this.options.htmlTemplate(e) : void 0,
									center: t,
									bounds: n.latLngBounds(t, t),
									properties: e
								})), o.call(i, s)
							}, this, "json_callback")
						}
					}),
					factory: function(e) {
						return new n.Control.Geocoder.Nominatim(e)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		10: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						options: {
							serviceUrl: "https://photon.komoot.de/api/",
							reverseUrl: "https://photon.komoot.de/reverse/",
							nameProperties: ["name", "street", "suburb", "hamlet", "town", "city", "state", "country"]
						},
						
						initialize: function(e) {
							n.setOptions(this, e)
						},
						
						geocode: function(e, t, o) {
							var i = n.extend({
								q: e
							}, this.options.geocodingQueryParams);
							s.getJSON(this.options.serviceUrl, i, n.bind(function(e) {
								t.call(o, this._decodeFeatures(e))
							}, this))
						},
						
						suggest: function(e, t, o) {
							return this.geocode(e, t, o)
						},
						
						reverse: function(e, t, o, i) {
							var r = n.extend({
								lat: e.lat,
								lon: e.lng
							}, this.options.geocodingQueryParams);
							s.getJSON(this.options.reverseUrl, r, n.bind(function(e) {
								o.call(i, this._decodeFeatures(e))
							}, this))
						},
						
						_decodeFeatures: function(e) {
							var t, o, s, i, r, a, l = [];
							if (e && e.features) for (t = 0; t < e.features.length; t++) s = (o = e.features[t]).geometry.coordinates, i = n.latLng(s[1], s[0]), a = (r = o.properties.extent) ? n.latLngBounds([r[1], r[0]], [r[3], r[2]]) : n.latLngBounds(i, i), l.push({
								name: this._deocodeFeatureName(o),
								html: this.options.htmlTemplate ? this.options.htmlTemplate(o) : void 0,
								center: i,
								bbox: a,
								properties: o.properties
							});
							
							return l
						},
						
						_deocodeFeatureName: function(e) {
							var t, o;
							for (t = 0; !o && t < this.options.nameProperties.length; t++) o = e.properties[this.options.nameProperties[t]];
							return o
						}
					}),
					factory: function(e) {
						return new n.Control.Geocoder.Photon(e)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		11: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("../util");
				t.exports = {
					class: n.Class.extend({
						options: {
							serviceUrl: "https://api.what3words.com/v2/"
						},
						
						initialize: function(e) {
							this._accessToken = e
						},
						
						geocode: function(e, t, o) {
							s.getJSON(this.options.serviceUrl + "forward", {
								key: this._accessToken,
								addr: e.split(/\s+/).join(".")
							}, function(e) {
								var s, i, r = [];
								e.hasOwnProperty("geometry") && (s = n.latLng(e.geometry.lat, e.geometry.lng), i = n.latLngBounds(s, s), r[0] = {
									name: e.words,
									bbox: i,
									center: s
								}), t.call(o, r)
							})
						},
						
						suggest: function(e, t, o) {
							return this.geocode(e, t, o)
						},
						
						reverse: function(e, t, o, i) {
							s.getJSON(this.options.serviceUrl + "reverse", {
								key: this._accessToken,
								coords: [e.lat, e.lng].join(",")
							}, function(e) {
								var t, s, r = [];
								200 == e.status.status && (t = n.latLng(e.geometry.lat, e.geometry.lng), s = n.latLngBounds(t, t), r[0] = {
									name: e.words,
									bbox: s,
									center: t
								}), o.call(i, r)
							})
						}
					}),
					factory: function(e) {
						return new n.Control.Geocoder.What3Words(e)
					}
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"../util": 13
		}],
		12: [function(e, t, o) {
			(function(o) {
				var n = "undefined" != typeof window ? window.L : void 0 !== o ? o.L : null,
					s = e("./control"),
					i = e("./geocoders/nominatim"),
					r = e("./geocoders/bing"),
					a = e("./geocoders/mapquest"),
					l = e("./geocoders/mapbox"),
					c = e("./geocoders/what3words"),
					d = e("./geocoders/google"),
					u = e("./geocoders/photon"),
					p = e("./geocoders/mapzen"),
					f = e("./geocoders/arcgis"),
					g = e("./geocoders/here");
				t.exports = n.Util.extend(s.class, {
					Nominatim: i.class,
					nominatim: i.factory,
					Bing: r.class,
					bing: r.factory,
					MapQuest: a.class,
					mapQuest: a.factory,
					Mapbox: l.class,
					mapbox: l.factory,
					What3Words: c.class,
					what3words: c.factory,
					Google: d.class,
					google: d.factory,
					Photon: u.class,
					photon: u.factory,
					Mapzen: p.class,
					mapzen: p.factory,
					ArcGis: f.class,
					arcgis: f.factory,
					HERE: g.class,
					here: g.factory
				}), n.Util.extend(n.Control, {
					Geocoder: t.exports,
					geocoder: s.factory
				})
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{
			"./control": 1,
			"./geocoders/arcgis": 2,
			"./geocoders/bing": 3,
			"./geocoders/google": 4,
			"./geocoders/here": 5,
			"./geocoders/mapbox": 6,
			"./geocoders/mapquest": 7,
			"./geocoders/mapzen": 8,
			"./geocoders/nominatim": 9,
			"./geocoders/photon": 10,
			"./geocoders/what3words": 11
		}],
		13: [function(e, t, o) {
			(function(e) {
				var o = "undefined" != typeof window ? window.L : void 0 !== e ? e.L : null,
					n = 0,
					s = function() {
						function e(e) {
							return n[e]
						}
						var t = /[&<>"'`]/g,
							o = /[&<>"'`]/,
							n = {
								"&": "&amp;",
								"<": "&lt;",
								">": "&gt;",
								'"': "&quot;",
								"'": "&#x27;",
								"`": "&#x60;"
							};
						
						return function(n) {
							return null == n ? "" : n ? (n = "" + n, o.test(n) ? n.replace(t, e) : n) : n + ""
						}
					}();
				
				t.exports = {
					jsonp: function(e, t, s, i, r) {
						var a = "_l_geocoder_" + n++;
						t[r || "callback"] = a, window[a] = o.Util.bind(s, i);
						var l = document.createElement("script");
						l.type = "text/javascript", l.src = e + o.Util.getParamString(t), l.id = a, document.getElementsByTagName("head")[0].appendChild(l)
					},
					
					getJSON: function(e, t, n) {
						var s = new XMLHttpRequest;
						s.onreadystatechange = function() {
							4 === s.readyState && n(200 === s.status || 304 === s.status ? JSON.parse(s.response) : "")
						}, s.open("GET", e + o.Util.getParamString(t), !0), s.setRequestHeader("Accept", "application/json"), s.send(null)
					},
					
					template: function(e, t) {
						return e.replace(/\{ *([\w_]+) *\}/g, function(e, o) {
							var n = t[o];
							return void 0 === n ? n = "" : "function" == typeof n && (n = n(t)), s(n)
						})
					},
					
					htmlEscape: s
				}
			}).call(this, "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {})
		},
		{}]
	}, {}, [12])(12)
});
