var require = {
	baseUrl : "js",
	shim : {
		"modal" : [ "jquery" ],
		"page" : [ "jquery" ],

		"tool" : [ "jquery" ],
		"validate" : [ "jquery" ]
	},
	paths : {
		/* lib */
		"jquery" : "lib/jquery",
		"modal" : "lib/zhsy/js/modal",
		"page" : "lib/zhsy/js/page",
		/* util */
		"checkctrl" : "util/checkctrl",
		"crud" : "util/crud",
		"tool" : "util/tool",
		"validate" : "util/validate"
	}
};