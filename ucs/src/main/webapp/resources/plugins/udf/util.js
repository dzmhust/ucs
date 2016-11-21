define(function(require, exports, module) {
	require('jdirk');
	var $ = require('jquery');
	/**
	 * 屏蔽字符串
	 */
	function _abbr(val,begin,end){
		if ($.isEmptyObject(val)){
			return '';
		}
		var diff = end - begin;
		var star = "";
		for (var i=0; i<diff; i++){
			star = star + "*";
		}
		val = val.replace(val.substring(begin,end),star);
		return val;
	}
	// 输出区域
	/**
	 * 屏蔽手机号
	 */
	exports.fmtMobile = function(val){
		return _abbr(val,3,7);
	}
	/**
	 * 屏蔽身份认证号
	 */
	exports.fmtIdCard = function(val){
		return _abbr(val,10,14);
	}
});