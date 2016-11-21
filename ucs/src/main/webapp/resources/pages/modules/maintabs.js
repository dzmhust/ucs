define(function(require, exports, module) {
	var $ = require('jquery');
	require('jdirk');
    $(function(){
        init();
    });
    function init(){
        initConfig();
        initAction();
    }
    function initConfig(){
    	
    }
    function initAction(){
    	// 关闭所有页签
        $('.closeAllTabs').on("click", function () {
            closeAllTabs();
        });
        // 关闭其他页签
        $('.closeOtherTabs').on("click", function(){
            closeOtherTabs();
        });
        // 页签左移
        $('.tab-left').bind('click',function(){
        	tabLeft();
        })
        // 页签右移
        $('.tab-right').bind('click',function(){
        	tabRight();
        })
        // 关闭页签
        $('.menu-tabs').on('click','.menu-tab i',closeTab);
        // 选择页签
        $('.menu-tabs').on('click','.menu-tab',selectTab);
    }
    /**
     * 判断页签是否存在
     */
    function existTab(tabId){
    	var isExist = false;
        $(".menu-tab").each(function () {
            if ($(this).data("id") == tabId) {
                if (!$(this).hasClass("active")) {
                    $(this).addClass("active").siblings(".menu-tab").removeClass("active");
                    g(this);
                    $(".main-content .tab_iframe").each(function () {
                        if ($(this).data("id") == tabId) {
                            $(this).show().siblings(".tab_iframe").hide();
                            isExist = true;
                        }
                    })
                }
                isExist = true;
            }
        });
        return isExist;
    }
    /**
     * 关闭所有页签
     */
    function closeAllTabs(){
    	// 关闭非第一个页签
        $(".page-tabs-content").children("[data-id]").each(function () {
            $('.tab_iframe[data-id="' + $(this).data("id") + '"]').remove();
            $(this).remove()
        });
        $(".page-tabs-content").css("margin-left", "0")
    }
    /**
     * 关闭其他页签 
     */
    function closeOtherTabs(){
    	$(".page-tabs-content").children("[data-id]").not(".active").each(function () {
            $('.tab_iframe[data-id="' + $(this).data("id") + '"]').remove();
            $(this).remove();
        });
        $(".page-tabs-content").css("margin-left", "0");
    }
    /**
     * 页签左移
     */
    function tabLeft(){
    	
    }
    /**
     * 页签右移
     */
    function tabRight(){
    	
    }
    /**
     * 选择页签
     */
    function selectTab(){
    	if (!$(this).hasClass("active")) {
            var tabId = $(this).data("id");
            $(".main-content .tab_iframe").each(function () {
                if ($(this).data("id") == tabId) {
                    $(this).show().siblings(".tab_iframe").hide();
                    return false
                }
            });
            $(this).addClass("active").siblings(".menu-tab").removeClass("active");
            showTab(this);
        }
    }
    /**
     * 关闭页签
     */
    function closeTab(){
    	var tabId = $(this).parents('.menu-tab').data('id');
    	var tabWidth = $(this).parents('.menu-tab').width();
    	if ($(this).parents('.menu-tab').hasClass('active')){
    		// 右边页签调整
    		var hasNext = $(this).parents('.menu-tab').next('.menu-tab').size()>0?true:false;
    		if (hasNext){
    			var nextTabId = $(this).parents(".menu-tab").next(".menu-tab:eq(0)").data("id");
    			$(this).parents(".menu-tab").next(".menu-tab:eq(0)").addClass("active");
    			$(".main-content .tab_iframe").each(function () {
                    if ($(this).data("id") == nextTabId) {
                        $(this).show().siblings(".tab_iframe").hide();
                        return false
                    }
                });
                var left = parseInt($(".page-tabs-content").css("margin-left"));
                if (left < 0) {
                    $(".page-tabs-content").animate({marginLeft: (left + l) + "px"}, "fast")
                }
                _closeTab(tabId,this);
    		}
    		// 左边页签调整
    		var hasPre = $(this).parents(".menu-tab").prev(".menu-tab").size()>0?true:false;
    		if (hasPre) {
                var preTabId = $(this).parents(".menu-tab").prev(".menu-tab:last").data("id");
                $(this).parents(".menu-tab").prev(".menu-tab:last").addClass("active");
                $(".main-content .tab_iframe").each(function () {
                    if ($(this).data("id") == preTabId) {
                        $(this).show().siblings(".tab_iframe").hide();
                        return false
                    }
                });
                _closeTab(tabId,this);
            }
            // 左右都没有
            if (!hasNext && !hasPre){
            	_closeTab(tabId,this);
            }
    	} else{
    		_closeTab(tabId,this);
    		showTab($('.menu-tab.active'));
    	}
    	// TODO 
    	return false;
    }
    /**
     * 关闭页签
     */
    function _closeTab(tabId,me){
    	$(me).parents('.menu-tab').remove();
		$('.main-content .tab_iframe').each(function(){
			if ($(this).data('id') == tabId){
				$(this).remove();
				return false;
			}
		})
    }
    /**
     * 计算元素的outerWidth宽度，
     * @param elements
     * @returns {number}
     */
    function caculateEleWidth(elements) {
        var width = 0;
        $(elements).each(function () {
            width += $(this).outerWidth(true)
        });
        return width
    }
    
    function showTab(tab){
		var preWidth = caculateEleWidth($(tab).prevAll());
		var nextWidth = caculateEleWidth($(tab).nextAll());
		var otherWidth = caculateEleWidth($(".content-tabs").children().not(".menu-tabs"));
		var k = $(".content-tabs").outerWidth(true) - otherWidth;
		var p = 0;
        if ($(".page-tabs-content").outerWidth() < k) {
            p = 0
        } else {
            if (nextWidth <= (k - $(tab).outerWidth(true) - $(tab).next().outerWidth(true))) {
                if ((k - $(tab).next().outerWidth(true)) > nextWidth) {
                    p = preWidth;
                    var m = tab;
                    while ((p - $(m).outerWidth()) > ($(".page-tabs-content").outerWidth() - k)) {
                        p -= $(m).prev().outerWidth();
                        m = $(m).prev()
                    }
                }
            } else {
                if (preWidth > (k - $(tab).outerWidth(true) - $(tab).prev().outerWidth(true))) {
                    p = preWidth - $(tab).prev().outerWidth(true)
                }
            }
        }
        $(".page-tabs-content").animate({marginLeft: 0 - p + "px"}, "fast")
    }
    // 输出区域
    /**
     * 添加页签
     */
    exports.addTab = function (url, title, id){
    	if ($.string.isNullOrEmpty(id)){
    		return false;
    	}
    	var isExist = existTab(id);
    	if (!isExist){
    		var tabTitle = '<a href="javascript:;" class="active menu-tab" data-id="' + id + '">' + title + ' <i class="fa fa-times-circle"></i></a>';
    		$('.menu-tab').removeClass('active');
    		$('.menu-tabs .page-tabs-content').append(tabTitle);
    		//
    		var tabContent = '<iframe class="tab_iframe" name="iframe' + id + '" width="100%" height="100%" src="' + url + '" frameborder="0" data-id="' + id + '" seamless></iframe>';
			$('#content-main').find('iframe.tab_iframe').hide();
			$('#content-main').append(tabContent);  
			showTab($('.menu-tab.active'));
    	}
    }
});