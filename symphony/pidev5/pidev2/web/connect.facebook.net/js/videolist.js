// #################################################################
// #                                                               #
// #           Parametres specifiques a artist_widget              #
// #                                                               #
// #################################################################

ULTIMEDIA_CODE_SRC = '';
ULTIMEDIA_ACTION = '/api/widget/videolistjs?j=new&t=' + new Date().getTime();
var otherPlayer=function(){
    var e=document.getElementsByTagName("embed");
    for(var t in e){
        if(typeof e[t].src!="undefined"){
            var n=e[t].src;
            if(n.indexOf("youtube.com/v")!=-1){
                return 1
            }
        }
    }
    var r=document.getElementsByTagName("iframe");
    for(var t in r){
        if(typeof r[t].src!="undefined"){
            var n=r[t].src;
            if(n.indexOf("youtube.com/embed")!=-1){
                return 1
            }
            if(n.indexOf("20minutos.tv/videoplayerjw")!=-1){
                return 2
            }
            if(n.indexOf("ultimedia.com/deliver")!=-1){
                return 3
            }
            if(n.indexOf("dailymotion.com/embed")!=-1){
                return 4
            }
            if(n.indexOf("launch.newsinc.com")!=-1){
                return 7
            }
			if(n.indexOf("player.m6web.fr")!=-1){
                return 8
            }
        }
    }
    var e=document.getElementsByTagName("object");
    for(var t in e){
        if(typeof e[t].name!="undefined"){
            var n=e[t].name;
            if(n.indexOf("kplayer")!=-1){
                return 5
            }
        }
        if(typeof e[t].class!="undefined"){
            var c=e[t].class;
            if(c.indexOf("BrightcoveExperience")!=-1){
                return 6
            }
        }
    }
    return 0
};

ULTIMEDIA_CODE_SRC+="&otherplayer="+encodeURIComponent(otherPlayer());
if ((typeof ULTIMEDIA_videolist != 'undefined') && (ULTIMEDIA_videolist !== '')) {ULTIMEDIA_CODE_SRC += '&videolist=' + encodeURIComponent(ULTIMEDIA_videolist);}
if ((typeof ULTIMEDIA_order != 'undefined') && (ULTIMEDIA_order !== '')) {ULTIMEDIA_CODE_SRC += '&order=' + encodeURIComponent(ULTIMEDIA_order);}

// #################################################################
// #                                                               #
// #                    Parametres communs                         #
// #                                                               #
// #################################################################

if ((typeof ULTIMEDIA_host != 'undefined') && (ULTIMEDIA_host !== '')) {
	_ultimedia_host = ULTIMEDIA_host;
} else {
	_ultimedia_host = '//www.ultimedia.com';
}

if (typeof _ultimedia_widget_id == "undefined") {
    _ultimedia_widget_id = 0;
} else {
    _ultimedia_widget_id ++;
}

ULTIMEDIA_CODE_SRC = _ultimedia_host + ULTIMEDIA_ACTION + ULTIMEDIA_CODE_SRC;
ULTIMEDIA_LOADING_SRC = _ultimedia_host + '/api/widget/loading?t=' + new Date().getTime();

if ((typeof document.URL != 'undefined') && (document.URL !== '')) {ULTIMEDIA_CODE_SRC += '&url=' + encodeURIComponent(document.URL);}
if ((typeof ULTIMEDIA_mdtk != 'undefined') && (ULTIMEDIA_mdtk !== '')) {ULTIMEDIA_CODE_SRC += '&mdtk=' + ULTIMEDIA_mdtk;ULTIMEDIA_LOADING_SRC += '&mdtk=' + ULTIMEDIA_mdtk;}
if ((typeof ULTIMEDIA_zone != 'undefined') && (ULTIMEDIA_zone !== '')) {ULTIMEDIA_CODE_SRC += '&zone=' + ULTIMEDIA_zone;ULTIMEDIA_LOADING_SRC += '&zone=' + ULTIMEDIA_zone;}
if ((typeof ULTIMEDIA_nb != 'undefined') && (ULTIMEDIA_nb !== '')) {ULTIMEDIA_CODE_SRC += '&nb=' + ULTIMEDIA_nb;} else if ((typeof ULTIMEDIA_limit != 'undefined') && (ULTIMEDIA_limit !== '')) {ULTIMEDIA_CODE_SRC += '&nb=' + ULTIMEDIA_limit;}
if ((typeof ULTIMEDIA_urlfacebook != 'undefined') && (ULTIMEDIA_urlfacebook !== '')) {ULTIMEDIA_CODE_SRC += '&urlfacebook=' + encodeURIComponent(ULTIMEDIA_urlfacebook);}
if ((typeof ULTIMEDIA_ad != 'undefined') && (ULTIMEDIA_ad !== '')) {ULTIMEDIA_CODE_SRC += '&ad=' + encodeURIComponent(ULTIMEDIA_ad);}
if ((typeof ULTIMEDIA_nocache != 'undefined') && (ULTIMEDIA_nocache !== '')) {ULTIMEDIA_CODE_SRC += '&nocache=' + encodeURIComponent(ULTIMEDIA_nocache);}
if ((typeof ULTIMEDIA_callback != 'undefined') && (ULTIMEDIA_callback !== '')) {ULTIMEDIA_CODE_SRC += '&callback=' + encodeURIComponent(ULTIMEDIA_callback);}
if ((typeof ULTIMEDIA_events != 'undefined') && (ULTIMEDIA_events !== '')) {ULTIMEDIA_CODE_SRC += '&player_events=' + encodeURIComponent(JSON.stringify(ULTIMEDIA_events));}
if ((typeof ULTIMEDIA_before_first_start != 'undefined') && (ULTIMEDIA_before_first_start !== '')) {ULTIMEDIA_CODE_SRC += '&before_first_start=' + encodeURIComponent(ULTIMEDIA_before_first_start);}
if ((typeof ULTIMEDIA_widget_title != 'undefined') && (ULTIMEDIA_widget_title !== '')) {ULTIMEDIA_CODE_SRC += '&widget_title=' + encodeURIComponent(ULTIMEDIA_widget_title);ULTIMEDIA_LOADING_SRC += '&widget_title=' + encodeURIComponent(ULTIMEDIA_widget_title);}
if ((typeof ULTIMEDIA_widget_footer != 'undefined') && (ULTIMEDIA_widget_footer !== '')) {ULTIMEDIA_CODE_SRC += '&widget_footer=' + encodeURIComponent(ULTIMEDIA_widget_footer);ULTIMEDIA_LOADING_SRC += '&widget_footer=' + encodeURIComponent(ULTIMEDIA_widget_footer);}
if ((typeof ULTIMEDIA_widget_header != 'undefined') && (ULTIMEDIA_widget_header !== '')) {ULTIMEDIA_CODE_SRC += '&widget_header=' + encodeURIComponent(ULTIMEDIA_widget_header);ULTIMEDIA_LOADING_SRC += '&widget_header=' + encodeURIComponent(ULTIMEDIA_widget_header);}
if ((typeof ULTIMEDIA_overlay_title != 'undefined') && (ULTIMEDIA_overlay_title !== '')) {ULTIMEDIA_CODE_SRC += '&overlay_title=' + encodeURIComponent(ULTIMEDIA_overlay_title);}
if ((typeof ULTIMEDIA_show_tooltips != 'undefined') && (ULTIMEDIA_show_tooltips !== '')) {
	if (ULTIMEDIA_show_tooltips === true) {
		ULTIMEDIA_CODE_SRC += '&show_tooltips=yes';
	} else if (ULTIMEDIA_show_tooltips === false) {
		ULTIMEDIA_CODE_SRC += '&show_tooltips=no';
	} else {
		ULTIMEDIA_CODE_SRC += '&show_tooltips=' + ULTIMEDIA_show_tooltips;
	}
}
if ((typeof ULTIMEDIA_autoplay != 'undefined') && (ULTIMEDIA_autoplay !== '')) {
	if (ULTIMEDIA_autoplay === true) {
		ULTIMEDIA_CODE_SRC += '&autoplay=yes';
	} else if (ULTIMEDIA_autoplay === false) {
		ULTIMEDIA_CODE_SRC += '&autoplay=no';
	} else {
		ULTIMEDIA_CODE_SRC += '&autoplay=' + ULTIMEDIA_autoplay;
	}
}
if ((typeof ULTIMEDIA_playlist != 'undefined') && (ULTIMEDIA_playlist !== '')) {
	if (ULTIMEDIA_playlist === true) {
		ULTIMEDIA_CODE_SRC += '&playlist=yes';
	} else if (ULTIMEDIA_playlist === false) {
		ULTIMEDIA_CODE_SRC += '&playlist=no';
	} else {
		ULTIMEDIA_CODE_SRC += '&playlist=' + ULTIMEDIA_playlist;
	}
}
if ((typeof ULTIMEDIA_width != 'undefined') && (ULTIMEDIA_width !== '')) {ULTIMEDIA_CODE_SRC += '&width=' + encodeURIComponent(ULTIMEDIA_width);ULTIMEDIA_LOADING_SRC += '&width=' + encodeURIComponent(ULTIMEDIA_width);}
if ((typeof ULTIMEDIA_height != 'undefined') && (ULTIMEDIA_height !== '')) {ULTIMEDIA_CODE_SRC += '&height=' + encodeURIComponent(ULTIMEDIA_height);ULTIMEDIA_LOADING_SRC += '&height=' + encodeURIComponent(ULTIMEDIA_height);}
if ((typeof ULTIMEDIA_layout == 'undefined') || (ULTIMEDIA_layout === '')) {
    ULTIMEDIA_layout = '';
}
ULTIMEDIA_CODE_SRC += '&layout=' + encodeURIComponent(ULTIMEDIA_layout);ULTIMEDIA_LOADING_SRC += '&layout=' + encodeURIComponent(ULTIMEDIA_layout);
if ((typeof ULTIMEDIA_default_videolist != 'undefined') && (ULTIMEDIA_default_videolist !== '')) {
    ULTIMEDIA_CODE_SRC += '&default_videolist=' + encodeURIComponent(ULTIMEDIA_default_videolist);
}
if ((typeof ULTIMEDIA_default_zone != 'undefined') && (ULTIMEDIA_default_zone !== '')) {
    ULTIMEDIA_CODE_SRC += '&default_zone=' + ULTIMEDIA_default_zone;
}
if ((typeof ULTIMEDIA_default_widget_title != 'undefined') && (ULTIMEDIA_default_widget_title !== '')) {
    ULTIMEDIA_CODE_SRC += '&default_widget_title=' + encodeURIComponent(ULTIMEDIA_default_widget_title);
}

//position
if ((typeof ULTIMEDIA_position != 'undefined') && (ULTIMEDIA_position !== '')) {ULTIMEDIA_CODE_SRC += '&position=' + encodeURIComponent(ULTIMEDIA_position);ULTIMEDIA_LOADING_SRC += '&position=' + encodeURIComponent(ULTIMEDIA_position);}
//width widget
if ((typeof ULTIMEDIA_width_widget != 'undefined') && (ULTIMEDIA_width_widget !== '')) {ULTIMEDIA_CODE_SRC += '&width_widget=' + encodeURIComponent(ULTIMEDIA_width_widget);ULTIMEDIA_LOADING_SRC += '&width_widget=' + encodeURIComponent(ULTIMEDIA_width_widget);}

// CSS params
if ((typeof ULTIMEDIA_css_title_font_color != 'undefined') && (ULTIMEDIA_css_title_font_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_title_font_color=' + encodeURIComponent(ULTIMEDIA_css_title_font_color);ULTIMEDIA_LOADING_SRC += '&css_title_font_color=' + encodeURIComponent(ULTIMEDIA_css_title_font_color);} // #B71318
if ((typeof ULTIMEDIA_css_title_font != 'undefined') && (ULTIMEDIA_css_title_font !== '')) {ULTIMEDIA_CODE_SRC += '&css_title_font=' + encodeURIComponent(ULTIMEDIA_css_title_font);ULTIMEDIA_LOADING_SRC += '&css_title_font=' + encodeURIComponent(ULTIMEDIA_css_title_font);}
if ((typeof ULTIMEDIA_css_title_text_align != 'undefined') && (ULTIMEDIA_css_title_text_align !== '')) {ULTIMEDIA_CODE_SRC += '&css_title_text_align=' + encodeURIComponent(ULTIMEDIA_css_title_text_align);ULTIMEDIA_LOADING_SRC += '&css_title_text_align=' + encodeURIComponent(ULTIMEDIA_css_title_text_align);} // center
if ((typeof ULTIMEDIA_css_title_background_color != 'undefined') && (ULTIMEDIA_css_title_background_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_title_background_color=' + encodeURIComponent(ULTIMEDIA_css_title_background_color);ULTIMEDIA_LOADING_SRC += '&css_title_background_color=' + encodeURIComponent(ULTIMEDIA_css_title_background_color);} // #B71318
if ((typeof ULTIMEDIA_css_title_widget_uppercase != 'undefined') && (ULTIMEDIA_css_title_widget_uppercase !== '')) {ULTIMEDIA_CODE_SRC += '&css_title_widget_uppercase=' + encodeURIComponent(ULTIMEDIA_css_title_widget_uppercase);ULTIMEDIA_LOADING_SRC += '&css_title_widget_uppercase=' + encodeURIComponent(ULTIMEDIA_css_title_widget_uppercase);} // text-transform

if ((typeof ULTIMEDIA_css_header_font!="undefined") && (ULTIMEDIA_css_header_font!=="")) {ULTIMEDIA_CODE_SRC += '&css_header_font=' + encodeURIComponent(ULTIMEDIA_css_header_font);ULTIMEDIA_LOADING_SRC += '&css_header_font=' + encodeURIComponent(ULTIMEDIA_css_header_font);}
if ((typeof ULTIMEDIA_css_header_font_color != 'undefined') && (ULTIMEDIA_css_header_font_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_header_font_color=' + encodeURIComponent(ULTIMEDIA_css_header_font_color);ULTIMEDIA_LOADING_SRC += '&css_header_font_color=' + encodeURIComponent(ULTIMEDIA_css_header_font_color);}
if ((typeof ULTIMEDIA_css_header_border != 'undefined') && (ULTIMEDIA_css_header_border !== '')) {ULTIMEDIA_CODE_SRC += '&css_header_border=' + encodeURIComponent(ULTIMEDIA_css_header_border);ULTIMEDIA_LOADING_SRC += '&css_header_border=' + encodeURIComponent(ULTIMEDIA_css_header_border);}

if ((typeof ULTIMEDIA_css_panel_position != 'undefined') && (ULTIMEDIA_css_panel_position !== '')) {ULTIMEDIA_CODE_SRC += '&css_panel_position=' + encodeURIComponent(ULTIMEDIA_css_panel_position);ULTIMEDIA_LOADING_SRC += '&css_panel_position=' + encodeURIComponent(ULTIMEDIA_css_panel_position);} // top
if ((typeof ULTIMEDIA_css_panel_font_size != 'undefined') && (ULTIMEDIA_css_panel_font_size !== '')) {ULTIMEDIA_CODE_SRC += '&css_panel_font_size=' + encodeURIComponent(ULTIMEDIA_css_panel_font_size);ULTIMEDIA_LOADING_SRC += '&css_panel_font_size=' + encodeURIComponent(ULTIMEDIA_css_panel_font_size);} // 16px
if ((typeof ULTIMEDIA_css_panel_font_color != 'undefined') && (ULTIMEDIA_css_panel_font_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_panel_font_color=' + encodeURIComponent(ULTIMEDIA_css_panel_font_color);ULTIMEDIA_LOADING_SRC += '&css_panel_font_color=' + encodeURIComponent(ULTIMEDIA_css_panel_font_color);} // #B71318
if ((typeof ULTIMEDIA_css_panel_text_align != 'undefined') && (ULTIMEDIA_css_panel_text_align !== '')) {ULTIMEDIA_CODE_SRC += '&css_panel_text_align=' + encodeURIComponent(ULTIMEDIA_css_panel_text_align);ULTIMEDIA_LOADING_SRC += '&css_panel_text_align=' + encodeURIComponent(ULTIMEDIA_css_panel_text_align);} // center
if ((typeof ULTIMEDIA_css_panel_text_uppercase != 'undefined') && (ULTIMEDIA_css_panel_text_uppercase !== '')) {ULTIMEDIA_CODE_SRC += '&css_panel_text_uppercase=' + encodeURIComponent(ULTIMEDIA_css_panel_text_uppercase);ULTIMEDIA_LOADING_SRC += '&css_panel_text_uppercase=' + encodeURIComponent(ULTIMEDIA_css_panel_text_uppercase);} // text-transform

if ((typeof ULTIMEDIA_css_thumb_background_color != 'undefined') && (ULTIMEDIA_css_thumb_background_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_thumb_background_color=' + encodeURIComponent(ULTIMEDIA_css_thumb_background_color);ULTIMEDIA_LOADING_SRC += '&css_thumb_background_color=' + encodeURIComponent(ULTIMEDIA_css_thumb_background_color);} // #B71318
if ((typeof ULTIMEDIA_css_thumb_border_color != 'undefined') && (ULTIMEDIA_css_thumb_border_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_thumb_border_color=' + encodeURIComponent(ULTIMEDIA_css_thumb_border_color);ULTIMEDIA_LOADING_SRC += '&css_thumb_border_color=' + encodeURIComponent(ULTIMEDIA_css_thumb_border_color);} // #B71318
if ((typeof ULTIMEDIA_css_thumb_infos_font_color != 'undefined') && (ULTIMEDIA_css_thumb_infos_font_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_thumb_infos_font_color=' + encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_color);ULTIMEDIA_LOADING_SRC += '&css_thumb_infos_font_color=' + encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_color);} // #B71318
if ((typeof ULTIMEDIA_css_thumb_infos_font != 'undefined') && (ULTIMEDIA_css_thumb_infos_font !== '')) {ULTIMEDIA_CODE_SRC += '&css_thumb_infos_font=' + encodeURIComponent(ULTIMEDIA_css_thumb_infos_font);ULTIMEDIA_LOADING_SRC += '&css_thumb_infos_font=' + encodeURIComponent(ULTIMEDIA_css_thumb_infos_font);} // 16px
if ((typeof ULTIMEDIA_css_thumb_background_color_hover != 'undefined') && (ULTIMEDIA_css_thumb_background_color_hover !== '')) {ULTIMEDIA_CODE_SRC += '&css_thumb_background_color_hover=' + encodeURIComponent(ULTIMEDIA_css_thumb_background_color_hover);ULTIMEDIA_LOADING_SRC += '&css_thumb_background_color_hover=' + encodeURIComponent(ULTIMEDIA_css_thumb_background_color_hover);} // #B71318
if ((typeof ULTIMEDIA_css_thumb_border_color_hover != 'undefined') && (ULTIMEDIA_css_thumb_border_color_hover !== '')) {ULTIMEDIA_CODE_SRC += '&css_thumb_border_color_hover=' + encodeURIComponent(ULTIMEDIA_css_thumb_border_color_hover);ULTIMEDIA_LOADING_SRC += '&css_thumb_border_color_hover=' + encodeURIComponent(ULTIMEDIA_css_thumb_border_color_hover);} // #B71318
if ((typeof ULTIMEDIA_css_thumb_infos_font_color_hover != 'undefined') && (ULTIMEDIA_css_thumb_infos_font_color_hover !== '')) {ULTIMEDIA_CODE_SRC += '&css_thumb_infos_font_color_hover=' + encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_color_hover);ULTIMEDIA_LOADING_SRC += '&css_thumb_infos_font_color_hover=' + encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_color_hover);} // #B71318
if ((typeof ULTIMEDIA_css_thumb_infos_font_hover != 'undefined') && (ULTIMEDIA_css_thumb_infos_font_hover !== '')) {ULTIMEDIA_CODE_SRC += '&css_thumb_infos_font_hover=' + encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_hover);ULTIMEDIA_LOADING_SRC += '&css_thumb_infos_font_hover=' + encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_hover);} // 16px
if ((typeof ULTIMEDIA_css_thumb_text_uppercase != 'undefined') && (ULTIMEDIA_css_thumb_text_uppercase !== '')) {ULTIMEDIA_CODE_SRC += '&css_thumb_text_uppercase=' + encodeURIComponent(ULTIMEDIA_css_thumb_text_uppercase);ULTIMEDIA_LOADING_SRC += 'css_thumb_text_uppercase=' + encodeURIComponent(ULTIMEDIA_css_thumb_text_uppercase);} // text-transform

if ((typeof ULTIMEDIA_css_list_overflow_x != 'undefined') && (ULTIMEDIA_css_list_overflow_x !== '')) {ULTIMEDIA_CODE_SRC += '&css_list_overflow_x=' + encodeURIComponent(ULTIMEDIA_css_list_overflow_x);ULTIMEDIA_LOADING_SRC += '&css_list_overflow_x=' + encodeURIComponent(ULTIMEDIA_css_list_overflow_x);} // hidden
if ((typeof ULTIMEDIA_css_list_overflow_y != 'undefined') && (ULTIMEDIA_css_list_overflow_y !== '')) {ULTIMEDIA_CODE_SRC += '&css_list_overflow_y=' + encodeURIComponent(ULTIMEDIA_css_list_overflow_y);ULTIMEDIA_LOADING_SRC += '&css_list_overflow_y=' + encodeURIComponent(ULTIMEDIA_css_list_overflow_y);} // auto
if ((typeof ULTIMEDIA_css_list_background_color != 'undefined') && (ULTIMEDIA_css_list_background_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_list_background_color=' + encodeURIComponent(ULTIMEDIA_css_list_background_color);ULTIMEDIA_LOADING_SRC += '&css_list_background_color=' + encodeURIComponent(ULTIMEDIA_css_list_background_color);} // auto

if ((typeof ULTIMEDIA_css_photosgallery_selected_border != 'undefined') && (ULTIMEDIA_css_photosgallery_selected_border !== '')) {ULTIMEDIA_CODE_SRC += '&css_photosgallery_selected_border=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_selected_border);ULTIMEDIA_LOADING_SRC += '&css_photosgallery_selected_border=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_selected_border);} // auto
if ((typeof ULTIMEDIA_css_photosgallery_nav_background_color != 'undefined') && (ULTIMEDIA_css_photosgallery_nav_background_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_photosgallery_nav_background_color=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_nav_background_color);ULTIMEDIA_LOADING_SRC += '&css_photosgallery_nav_background_color=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_nav_background_color);} // auto
if ((typeof ULTIMEDIA_css_photosgallery_button_nav_font_color != 'undefined') && (ULTIMEDIA_css_photosgallery_button_nav_font_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_photosgallery_button_nav_font_color=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_font_color);ULTIMEDIA_LOADING_SRC += '&css_photosgallery_button_nav_font_color=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_font_color);} // auto
if ((typeof ULTIMEDIA_css_photosgallery_button_nav_background_color != 'undefined') && (ULTIMEDIA_css_photosgallery_button_nav_background_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_photosgallery_button_nav_background_color=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_background_color);ULTIMEDIA_LOADING_SRC += '&css_photosgallery_button_nav_background_color=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_background_color);} // auto
if ((typeof ULTIMEDIA_css_photosgallery_button_nav_font_color_hover != 'undefined') && (ULTIMEDIA_css_photosgallery_button_nav_font_color_hover !== '')) {ULTIMEDIA_CODE_SRC += '&css_photosgallery_button_nav_font_color_hover=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_font_color_hover);ULTIMEDIA_LOADING_SRC += '&css_photosgallery_button_nav_font_color_hover=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_font_color_hover);} // auto
if ((typeof ULTIMEDIA_css_photosgallery_button_nav_background_color_hover != 'undefined') && (ULTIMEDIA_css_photosgallery_button_nav_background_color_hover !== '')) {ULTIMEDIA_CODE_SRC += '&css_photosgallery_button_nav_background_color_hover=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_background_color_hover);ULTIMEDIA_LOADING_SRC += 'css_photosgallery_button_nav_background_color_hover=' + encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_background_color_hover);} // auto

if ((typeof ULTIMEDIA_css_footer_font_color != 'undefined') && (ULTIMEDIA_css_footer_font_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_footer_font_color=' + encodeURIComponent(ULTIMEDIA_css_footer_font_color);ULTIMEDIA_LOADING_SRC += '&css_footer_font_color=' + encodeURIComponent(ULTIMEDIA_css_footer_font_color);} // #333
if ((typeof ULTIMEDIA_css_footer_text_align != 'undefined') && (ULTIMEDIA_css_footer_text_align !== '')) {ULTIMEDIA_CODE_SRC += '&css_footer_text_align=' + encodeURIComponent(ULTIMEDIA_css_footer_text_align);ULTIMEDIA_LOADING_SRC += '&css_title_footer_align=' + encodeURIComponent(ULTIMEDIA_css_footer_text_align);} // left


// BRANDED CONTENT
if ((typeof ULTIMEDIA_css_background_color != 'undefined') && (ULTIMEDIA_css_background_color !== '')) {ULTIMEDIA_CODE_SRC += '&css_background_color=' + encodeURIComponent(ULTIMEDIA_css_background_color);ULTIMEDIA_LOADING_SRC += '&css_background_color=' + encodeURIComponent(ULTIMEDIA_css_background_color);} // transparent
if ((typeof ULTIMEDIA_css_background_image != 'undefined') && (ULTIMEDIA_css_background_image !== '')) {ULTIMEDIA_CODE_SRC += '&css_background_image=' + encodeURIComponent(ULTIMEDIA_css_background_image);ULTIMEDIA_LOADING_SRC += '&css_background_image=' + encodeURIComponent(ULTIMEDIA_css_background_image);} // none
if ((typeof ULTIMEDIA_css_background_repeat != 'undefined') && (ULTIMEDIA_css_background_repeat !== '')) {ULTIMEDIA_CODE_SRC += '&css_background_repeat=' + encodeURIComponent(ULTIMEDIA_css_background_repeat);ULTIMEDIA_LOADING_SRC += '&css_background_repeat=' + encodeURIComponent(ULTIMEDIA_css_background_repeat);} // no-repeat
if ((typeof ULTIMEDIA_css_background_position != 'undefined') && (ULTIMEDIA_css_background_position !== '')) {ULTIMEDIA_CODE_SRC += '&css_background_position=' + encodeURIComponent(ULTIMEDIA_css_background_position);ULTIMEDIA_LOADING_SRC += '&css_background_position=' + encodeURIComponent(ULTIMEDIA_css_background_position);} // 0 0

// LOGO BRANDED
if ((typeof ULTIMEDIA_source_logo_brand != 'undefined') && (ULTIMEDIA_source_logo_brand !== '')) {ULTIMEDIA_CODE_SRC += '&source_logo_brand=' + encodeURIComponent(ULTIMEDIA_source_logo_brand);ULTIMEDIA_LOADING_SRC += '&source_logo_brand=' + encodeURIComponent(ULTIMEDIA_source_logo_brand);} // " "
if ((typeof ULTIMEDIA_url_logo_brand != 'undefined') && (ULTIMEDIA_url_logo_brand !== '')) {ULTIMEDIA_CODE_SRC += '&url_logo_brand=' + encodeURIComponent(ULTIMEDIA_url_logo_brand);ULTIMEDIA_LOADING_SRC += '&url_logo_brand=' + encodeURIComponent(ULTIMEDIA_url_logo_brand);} // "#"

// JW
if ((typeof(jwplayer) != 'undefined') && (typeof(DTKPlayer) == 'undefined')) {ULTIMEDIA_CODE_SRC += '&jw=1'}

if (typeof ULTIMEDIA_async == 'undefined') {ULTIMEDIA_async = true;}


_ultimedia_needs = new Array();
_ultimedia_needs.push('jquery');
if ((('undefined' == typeof window.jQuery) || ('undefined' == typeof window.jQuery().tooltipster)) && (('undefined' == typeof ULTIMEDIA_layout) || ((ULTIMEDIA_layout != 'pix_list') && (ULTIMEDIA_layout != 'single') && (ULTIMEDIA_layout != 'text_list') && (ULTIMEDIA_layout != 'bottom_list') && (ULTIMEDIA_layout != 'bottom_list_automoto') && (ULTIMEDIA_layout != 'pix_list_right') && (ULTIMEDIA_layout != 'pix_list_right_slide') && (ULTIMEDIA_layout != 'page_top') && (ULTIMEDIA_layout != 'page_top_grazia') && (ULTIMEDIA_layout != 'page_top_light') && (ULTIMEDIA_layout != 'page_top_header') && (ULTIMEDIA_layout != 'page_top_v2')))) {
    _ultimedia_needs.push('tooltipster');
}
if ((('undefined' == typeof window.jQuery) || ('undefined' == typeof window.jQuery().sliderkit)) && ((ULTIMEDIA_layout != 'single') && (ULTIMEDIA_layout != 'pix_list') && (ULTIMEDIA_layout != 'text_list') && (ULTIMEDIA_layout != 'bottom_list') && (ULTIMEDIA_layout != 'bottom_list_automoto') && (ULTIMEDIA_layout != 'wall_pix') && (ULTIMEDIA_layout != 'bottom_wallpix_cinema') && (ULTIMEDIA_layout != 'bottom_wallpix_actus') && (ULTIMEDIA_layout != 'bottom_wallpix_people') && (ULTIMEDIA_layout != 'bottom_wallpix_top_clip_fr') && (ULTIMEDIA_layout != 'bottom_wallpix_jv') && (ULTIMEDIA_layout != 'wallpix_cine_demo_digiteka') && (ULTIMEDIA_layout != 'wallpix_cine_telerama') && (ULTIMEDIA_layout != 'pix_list_right') && (ULTIMEDIA_layout != 'pix_list_right_slide') && (ULTIMEDIA_layout != 'page_top') && (ULTIMEDIA_layout != 'page_top_grazia') && (ULTIMEDIA_layout != 'page_top_light') && (ULTIMEDIA_layout != 'page_top_header') && (ULTIMEDIA_layout != 'page_top_v2'))) {
    _ultimedia_needs.push('sliderkit');
}
if ((('undefined' == typeof window.jQuery) || ('undefined' == typeof window.jQuery().jcarousel)) && ((ULTIMEDIA_layout == 'pix_list_right') || (ULTIMEDIA_layout == 'pix_list_right_slide') || (ULTIMEDIA_layout == 'page_top') || (ULTIMEDIA_layout == 'page_top_grazia') || (ULTIMEDIA_layout == 'page_top_light') || (ULTIMEDIA_layout == 'page_top_header') || (ULTIMEDIA_layout == 'page_top_v2'))) {
    _ultimedia_needs.push('jcarousel');
}
if (_ultimedia_needs.length > 0) {
    ULTIMEDIA_CODE_SRC += "&needs=" + _ultimedia_needs.join(',');
}

if ((typeof ULTIMEDIA_target != 'undefined') && (ULTIMEDIA_target !== '') && (document.getElementById(ULTIMEDIA_target)) && (ULTIMEDIA_async === true)) {
	ULTIMEDIA_CODE_SRC += '&target=' + encodeURIComponent(ULTIMEDIA_target);
	if (document.readyState == 'complete') {
		_ultimedia_script = document.createElement('script');
		_ultimedia_script.setAttribute('type', 'text/javascript');
		_ultimedia_script.setAttribute('src', ULTIMEDIA_CODE_SRC);
		document.getElementById(ULTIMEDIA_target).appendChild(_ultimedia_script);
	} else {
		if (typeof(_ultimedia_targets) == 'undefined') {
			_ultimedia_targets = new Array();
		}
		_ultimedia_targets[ULTIMEDIA_target] = ULTIMEDIA_CODE_SRC;
		if (typeof(_ultimedia_onload) == 'undefined') {
			_ultimedia_onload = function() {
                _ultimedia_onload_done = true;
				for (_ultimedia_target in _ultimedia_targets) {
					if (document.getElementById(_ultimedia_target)) {
						_ultimedia_script = document.createElement('script');
						_ultimedia_script.setAttribute('type', 'text/javascript');
						_ultimedia_script.setAttribute('src', _ultimedia_targets[_ultimedia_target]);
						document.getElementById(_ultimedia_target).appendChild(_ultimedia_script);
					}
				}
			};
		}
		if (typeof window.addEventListener != 'undefined') {
			window.addEventListener('load', _ultimedia_onload, false);
		} else if (typeof document.addEventListener != 'undefined') {
			document.addEventListener('load', _ultimedia_onload, false);
		} else if (typeof window.attachEvent != 'undefined') {
			window.attachEvent('onload', _ultimedia_onload);
		} else {
			if (typeof window.onload == 'function') {
				var _ultimedia_existing_onload = window.onload;
				window.onload = function() {
					_ultimedia_existing_onload();
					_ultimedia_onload();
				};
			} else {
				window.onload = _ultimedia_onload;
			}
		}
        if (typeof(_ultimedia_onload_check) == 'undefined') {
            _ultimedia_onload_done = false;
            _ultimedia_onload_check = function() {
                if ((document.readyState == 'complete') && !_ultimedia_onload_done) {
                    _ultimedia_onload();
                } else if (!_ultimedia_onload_done) {
                    setTimeout('_ultimedia_onload_check()', 1000);
                }
            };
            setTimeout('_ultimedia_onload_check()', 1000);
        }
	}
} else {
    ULTIMEDIA_target = ((typeof ULTIMEDIA_target != 'undefined') && (ULTIMEDIA_target !== '')) ? ULTIMEDIA_target : ('_ultimedia_widget_wrapper' + ((_ultimedia_widget_id != 0) ? '_'+_ultimedia_widget_id : ''));
    if (!document.getElementById(ULTIMEDIA_target)) {
        document.write('<div id="' + ULTIMEDIA_target + '"></div>');
    }
    ULTIMEDIA_CODE_SRC += '&target=' + encodeURIComponent(ULTIMEDIA_target);
	document.write('<scr' + 'ipt type="text/javascript" src="' + ULTIMEDIA_CODE_SRC + '"></scr' + 'ipt>');
}

if (typeof ULTIMEDIA_param == "undefined") {
	var ULTIMEDIA_param = new Array();
}
var ULTIMEDIA_param_length = ULTIMEDIA_param.length;
ULTIMEDIA_param[ULTIMEDIA_param_length] = ULTIMEDIA_CODE_SRC;

// Reset (si plusieurs widgets)
ULTIMEDIA_videolist = '';
ULTIMEDIA_order = '';
ULTIMEDIA_host = '';
ULTIMEDIA_mdtk = '';
ULTIMEDIA_zone = '';
ULTIMEDIA_nb = '';
ULTIMEDIA_urlfacebook = '';
ULTIMEDIA_ad = '';
ULTIMEDIA_callback = '';
ULTIMEDIA_widget_title = '';
ULTIMEDIA_widget_footer = '';
ULTIMEDIA_widget_header = '';
ULTIMEDIA_overlay_title = '';
ULTIMEDIA_show_tooltips = '';
ULTIMEDIA_autoplay = '';
ULTIMEDIA_playlist = '';
ULTIMEDIA_width = '';
ULTIMEDIA_height = '';
ULTIMEDIA_layout = '';
ULTIMEDIA_default_videolist = '';
ULTIMEDIA_default_zone = '';
ULTIMEDIA_default_widget_title = '';
ULTIMEDIA_css_title_font_color = '';
ULTIMEDIA_css_title_font = '';
ULTIMEDIA_css_title_text_align = '';
ULTIMEDIA_css_title_background_color = '';
ULTIMEDIA_css_panel_position = '';
ULTIMEDIA_css_panel_font_size = '';
ULTIMEDIA_css_panel_font_color = '';
ULTIMEDIA_css_panel_text_align = '';
ULTIMEDIA_css_thumb_background_color = '';
ULTIMEDIA_css_thumb_border_color = '';
ULTIMEDIA_css_thumb_infos_font_color = '';
ULTIMEDIA_css_thumb_infos_font = '';
ULTIMEDIA_css_thumb_background_color_hover = '';
ULTIMEDIA_css_thumb_border_color_hover = '';
ULTIMEDIA_css_thumb_infos_font_color_hover = '';
ULTIMEDIA_css_thumb_infos_font_hover = '';
ULTIMEDIA_css_list_overflow_x = '';
ULTIMEDIA_css_list_overflow_y = '';
ULTIMEDIA_css_list_background_color = '';
ULTIMEDIA_css_photosgallery_selected_border = '';
ULTIMEDIA_css_photosgallery_nav_background_color = '';
ULTIMEDIA_css_photosgallery_button_nav_font_color = '';
ULTIMEDIA_css_photosgallery_button_nav_background_color = '';
ULTIMEDIA_css_photosgallery_button_nav_font_color_hover = '';
ULTIMEDIA_css_photosgallery_button_nav_background_color_hover = '';
ULTIMEDIA_target = '';
ULTIMEDIA_css_title_widget_uppercase = '';
ULTIMEDIA_css_panel_text_uppercase = '';
ULTIMEDIA_css_thumb_text_uppercase = '';
ULTIMEDIA_css_footer_font_color = '';
ULTIMEDIA_css_footer_text_align = '';
ULTIMEDIA_css_background_color = '';
ULTIMEDIA_css_background_image = '';
ULTIMEDIA_css_background_repeat = '';
ULTIMEDIA_css_background_position = '';
ULTIMEDIA_source_logo_brand = '';
ULTIMEDIA_url_logo_brand = '';
ULTIMEDIA_css_header_font = '';
ULTIMEDIA_css_header_font_color = '';
ULTIMEDIA_css_header_border = '';
if(typeof ULTIMEDIA_resize!="undefined"&&ULTIMEDIA_resize==true){var pne=document.getElementById(ULTIMEDIA_target).parentNode;var pne_pl=window.getComputedStyle(pne,null).getPropertyValue("padding-left").replace(/[A-Za-z$-]/g,"");var pne_pr=window.getComputedStyle(pne,null).getPropertyValue("padding-right").replace(/[A-Za-z$-]/g,"");if(ULTIMEDIA_layout=="page_top"||ULTIMEDIA_layout=="page_top_v2"||ULTIMEDIA_layout=="page_top_header"||ULTIMEDIA_layout=="page_top_grazia"){if(typeof ULTIMEDIA_width!="undefined"&&ULTIMEDIA_width!==""){var ULTIMEDIA_width=ULTIMEDIA_width*(pne.offsetWidth-pne_pl-pne_pr)/ULTIMEDIA_width_widget}else if(typeof ULTIMEDIA_width_widget!="undefined"&&ULTIMEDIA_width_widget!==""){var ULTIMEDIA_old_width_widget=ULTIMEDIA_width_widget}var ULTIMEDIA_width_widget=pne.offsetWidth-pne_pl-pne_pr}else{var ULTIMEDIA_width=pne.offsetWidth-pne_pl-pne_pr}}ULTIMEDIA_CODE_SRC="";ULTIMEDIA_ACTION="/api/widget/jsall?j=new&t="+(new Date).getTime();var otherPlayer=function(){var e=document.getElementsByTagName("embed");for(var t in e){if(typeof e[t].src!="undefined"){var n=e[t].src;if(n.indexOf("youtube.com/v")!=-1){return 1}}}var r=document.getElementsByTagName("iframe");for(var t in r){if(typeof r[t].src!="undefined"){var n=r[t].src;if(n.indexOf("youtube.com/embed")!=-1){return 1}if(n.indexOf("20minutos.tv/videoplayerjw")!=-1){return 2}if(n.indexOf("ultimedia.com/deliver")!=-1){return 3}if(n.indexOf("dailymotion.com/embed")!=-1){return 4}if(n.indexOf("launch.newsinc.com")!=-1){return 7}if(n.indexOf("player.m6web.fr")!=-1){return 8}}}var e=document.getElementsByTagName("object");for(var t in e){if(typeof e[t].name!="undefined"){var n=e[t].name;if(n.indexOf("kplayer")!=-1){return 5}}}return 0};ULTIMEDIA_CODE_SRC+="&otherplayer="+encodeURIComponent(otherPlayer());if(typeof ULTIMEDIA_search!="undefined"&&ULTIMEDIA_search!==""){ULTIMEDIA_CODE_SRC+="&search="+encodeURIComponent(ULTIMEDIA_search)}if(typeof ULTIMEDIA_index!="undefined"&&ULTIMEDIA_index!==""){ULTIMEDIA_CODE_SRC+="&index="+encodeURIComponent(ULTIMEDIA_index)}if(typeof ULTIMEDIA_mode!="undefined"&&ULTIMEDIA_mode!==""){ULTIMEDIA_CODE_SRC+="&mode="+encodeURIComponent(ULTIMEDIA_mode)}if(typeof ULTIMEDIA_date!="undefined"&&ULTIMEDIA_date!==""){ULTIMEDIA_CODE_SRC+="&date="+encodeURIComponent(ULTIMEDIA_date)}if(typeof ULTIMEDIA_host!="undefined"&&ULTIMEDIA_host!==""){_ultimedia_host=ULTIMEDIA_host}else{_ultimedia_host=(window.location.protocol == 'https' ? 'https' : 'http') + "://www.ultimedia.com"}if(typeof _ultimedia_widget_id=="undefined"){_ultimedia_widget_id=0}else{_ultimedia_widget_id++}ULTIMEDIA_CODE_SRC=_ultimedia_host+ULTIMEDIA_ACTION+ULTIMEDIA_CODE_SRC;ULTIMEDIA_LOADING_SRC=_ultimedia_host+"/api/widget/loading?t="+(new Date).getTime();if(typeof document.URL!="undefined"&&document.URL!==""){ULTIMEDIA_CODE_SRC+="&url="+encodeURIComponent(document.URL)}if(typeof ULTIMEDIA_mdtk!="undefined"&&ULTIMEDIA_mdtk!==""){ULTIMEDIA_CODE_SRC+="&mdtk="+ULTIMEDIA_mdtk;ULTIMEDIA_LOADING_SRC+="&mdtk="+ULTIMEDIA_mdtk}if(typeof ULTIMEDIA_zone!="undefined"&&ULTIMEDIA_zone!==""){ULTIMEDIA_CODE_SRC+="&zone="+ULTIMEDIA_zone;ULTIMEDIA_LOADING_SRC+="&zone="+ULTIMEDIA_zone}if(typeof ULTIMEDIA_resize!="undefined"&&ULTIMEDIA_resize!==""){ULTIMEDIA_CODE_SRC+="&resize="+ULTIMEDIA_resize;ULTIMEDIA_LOADING_SRC+="&resize="+ULTIMEDIA_resize}if(typeof ULTIMEDIA_interval!="undefined"&&ULTIMEDIA_interval!==""){ULTIMEDIA_CODE_SRC+="&interval="+ULTIMEDIA_interval;ULTIMEDIA_LOADING_SRC+="&interval="+ULTIMEDIA_interval}if(typeof ULTIMEDIA_nb!="undefined"&&ULTIMEDIA_nb!==""){ULTIMEDIA_CODE_SRC+="&nb="+ULTIMEDIA_nb}else if(typeof ULTIMEDIA_limit!="undefined"&&ULTIMEDIA_limit!==""){ULTIMEDIA_CODE_SRC+="&nb="+ULTIMEDIA_limit}if(typeof ULTIMEDIA_urlfacebook!="undefined"&&ULTIMEDIA_urlfacebook!==""){ULTIMEDIA_CODE_SRC+="&urlfacebook="+encodeURIComponent(ULTIMEDIA_urlfacebook)}if(typeof ULTIMEDIA_ad!="undefined"&&ULTIMEDIA_ad!==""){ULTIMEDIA_CODE_SRC+="&ad="+encodeURIComponent(ULTIMEDIA_ad)}if(typeof ULTIMEDIA_nocache!="undefined"&&ULTIMEDIA_nocache!==""){ULTIMEDIA_CODE_SRC+="&nocache="+encodeURIComponent(ULTIMEDIA_nocache)}if(typeof ULTIMEDIA_owner!="undefined"&&ULTIMEDIA_owner!==""){ULTIMEDIA_CODE_SRC+="&owner_id="+encodeURIComponent(ULTIMEDIA_owner)}if(typeof ULTIMEDIA_callback!="undefined"&&ULTIMEDIA_callback!==""){ULTIMEDIA_CODE_SRC+="&callback="+encodeURIComponent(ULTIMEDIA_callback)}if ((typeof ULTIMEDIA_events != 'undefined') && (ULTIMEDIA_events !== '')) {ULTIMEDIA_CODE_SRC += '&player_events=' + encodeURIComponent(JSON.stringify(ULTIMEDIA_events));}if(typeof ULTIMEDIA_before_first_start!="undefined"&&ULTIMEDIA_before_first_start!==""){ULTIMEDIA_CODE_SRC+="&before_first_start="+encodeURIComponent(ULTIMEDIA_before_first_start)}if(typeof ULTIMEDIA_widget_title!="undefined"&&ULTIMEDIA_widget_title!==""){ULTIMEDIA_CODE_SRC+="&widget_title="+encodeURIComponent(ULTIMEDIA_widget_title);ULTIMEDIA_LOADING_SRC+="&widget_title="+encodeURIComponent(ULTIMEDIA_widget_title)}if(typeof ULTIMEDIA_widget_footer!="undefined"&&ULTIMEDIA_widget_footer!==""){ULTIMEDIA_CODE_SRC+="&widget_footer="+encodeURIComponent(ULTIMEDIA_widget_footer);ULTIMEDIA_LOADING_SRC+="&widget_footer="+encodeURIComponent(ULTIMEDIA_widget_footer)}if(typeof ULTIMEDIA_widget_header!="undefined"&&ULTIMEDIA_widget_header!==""){ULTIMEDIA_CODE_SRC+="&widget_header="+encodeURIComponent(ULTIMEDIA_widget_header);ULTIMEDIA_LOADING_SRC+="&widget_header="+encodeURIComponent(ULTIMEDIA_widget_header)}if(typeof ULTIMEDIA_css_header_font!="undefined"&&ULTIMEDIA_css_header_font!==""){ULTIMEDIA_CODE_SRC+="&css_header_font="+encodeURIComponent(ULTIMEDIA_css_header_font);ULTIMEDIA_LOADING_SRC+="&css_header_font="+encodeURIComponent(ULTIMEDIA_css_header_font)}if(typeof ULTIMEDIA_css_header_font_color!="undefined"&&ULTIMEDIA_css_header_font_color!==""){ULTIMEDIA_CODE_SRC+="&css_header_font_color="+encodeURIComponent(ULTIMEDIA_css_header_font_color);ULTIMEDIA_LOADING_SRC+="&css_header_font_color="+encodeURIComponent(ULTIMEDIA_css_header_font_color)}if(typeof ULTIMEDIA_css_header_border!="undefined"&&ULTIMEDIA_css_header_border!==""){ULTIMEDIA_CODE_SRC+="&css_header_border="+encodeURIComponent(ULTIMEDIA_css_header_border);ULTIMEDIA_LOADING_SRC+="&css_header_border="+encodeURIComponent(ULTIMEDIA_css_header_border)}if(typeof ULTIMEDIA_overlay_title!="undefined"&&ULTIMEDIA_overlay_title!==""){ULTIMEDIA_CODE_SRC+="&overlay_title="+encodeURIComponent(ULTIMEDIA_overlay_title)}if(typeof ULTIMEDIA_show_tooltips!="undefined"&&ULTIMEDIA_show_tooltips!==""){if(ULTIMEDIA_show_tooltips===true){ULTIMEDIA_CODE_SRC+="&show_tooltips=yes"}else if(ULTIMEDIA_show_tooltips===false){ULTIMEDIA_CODE_SRC+="&show_tooltips=no"}else{ULTIMEDIA_CODE_SRC+="&show_tooltips="+ULTIMEDIA_show_tooltips}}if(typeof ULTIMEDIA_autoplay!="undefined"&&ULTIMEDIA_autoplay!==""){if(ULTIMEDIA_autoplay===true){ULTIMEDIA_CODE_SRC+="&autoplay=yes"}else if(ULTIMEDIA_autoplay===false){ULTIMEDIA_CODE_SRC+="&autoplay=no"}else{ULTIMEDIA_CODE_SRC+="&autoplay="+ULTIMEDIA_autoplay}}if(typeof ULTIMEDIA_playlist!="undefined"&&ULTIMEDIA_playlist!==""){if(ULTIMEDIA_playlist===true){ULTIMEDIA_CODE_SRC+="&playlist=yes"}else if(ULTIMEDIA_playlist===false){ULTIMEDIA_CODE_SRC+="&playlist=no"}else{ULTIMEDIA_CODE_SRC+="&playlist="+ULTIMEDIA_playlist}}if(typeof ULTIMEDIA_width!="undefined"&&ULTIMEDIA_width!==""){ULTIMEDIA_CODE_SRC+="&width="+encodeURIComponent(ULTIMEDIA_width);ULTIMEDIA_LOADING_SRC+="&width="+encodeURIComponent(ULTIMEDIA_width)}if(typeof ULTIMEDIA_height!="undefined"&&ULTIMEDIA_height!==""){ULTIMEDIA_CODE_SRC+="&height="+encodeURIComponent(ULTIMEDIA_height);ULTIMEDIA_LOADING_SRC+="&height="+encodeURIComponent(ULTIMEDIA_height)}if(typeof ULTIMEDIA_layout=="undefined"||ULTIMEDIA_layout===""){ULTIMEDIA_layout="bottom_thumbs"}ULTIMEDIA_CODE_SRC+="&layout="+encodeURIComponent(ULTIMEDIA_layout);ULTIMEDIA_LOADING_SRC+="&layout="+encodeURIComponent(ULTIMEDIA_layout);if(typeof ULTIMEDIA_default_videolist!="undefined"&&ULTIMEDIA_default_videolist!==""){ULTIMEDIA_CODE_SRC+="&default_videolist="+encodeURIComponent(ULTIMEDIA_default_videolist)}if(typeof ULTIMEDIA_default_zone!="undefined"&&ULTIMEDIA_default_zone!==""){ULTIMEDIA_CODE_SRC+="&default_zone="+ULTIMEDIA_default_zone}if(typeof ULTIMEDIA_default_widget_title!="undefined"&&ULTIMEDIA_default_widget_title!==""){ULTIMEDIA_CODE_SRC+="&default_widget_title="+encodeURIComponent(ULTIMEDIA_default_widget_title)}if(typeof ULTIMEDIA_position!="undefined"&&ULTIMEDIA_position!==""){ULTIMEDIA_CODE_SRC+="&position="+encodeURIComponent(ULTIMEDIA_position);ULTIMEDIA_LOADING_SRC+="&position="+encodeURIComponent(ULTIMEDIA_position)}if(typeof ULTIMEDIA_width_widget!="undefined"&&ULTIMEDIA_width_widget!==""){ULTIMEDIA_CODE_SRC+="&width_widget="+encodeURIComponent(ULTIMEDIA_width_widget);ULTIMEDIA_LOADING_SRC+="&width_widget="+encodeURIComponent(ULTIMEDIA_width_widget)}if(typeof ULTIMEDIA_old_width_widget!="undefined"&&ULTIMEDIA_old_width_widget!==""){ULTIMEDIA_CODE_SRC+="&old_width_widget="+encodeURIComponent(ULTIMEDIA_old_width_widget);ULTIMEDIA_LOADING_SRC+="&old_width_widget="+encodeURIComponent(ULTIMEDIA_old_width_widget)}if(typeof ULTIMEDIA_css_title_font_color!="undefined"&&ULTIMEDIA_css_title_font_color!==""){ULTIMEDIA_CODE_SRC+="&css_title_font_color="+encodeURIComponent(ULTIMEDIA_css_title_font_color);ULTIMEDIA_LOADING_SRC+="&css_title_font_color="+encodeURIComponent(ULTIMEDIA_css_title_font_color)}if(typeof ULTIMEDIA_css_title_font!="undefined"&&ULTIMEDIA_css_title_font!==""){ULTIMEDIA_CODE_SRC+="&css_title_font="+encodeURIComponent(ULTIMEDIA_css_title_font);ULTIMEDIA_LOADING_SRC+="&css_title_font="+encodeURIComponent(ULTIMEDIA_css_title_font)}if(typeof ULTIMEDIA_css_title_text_align!="undefined"&&ULTIMEDIA_css_title_text_align!==""){ULTIMEDIA_CODE_SRC+="&css_title_text_align="+encodeURIComponent(ULTIMEDIA_css_title_text_align);ULTIMEDIA_LOADING_SRC+="&css_title_text_align="+encodeURIComponent(ULTIMEDIA_css_title_text_align)}if(typeof ULTIMEDIA_css_title_background_color!="undefined"&&ULTIMEDIA_css_title_background_color!==""){ULTIMEDIA_CODE_SRC+="&css_title_background_color="+encodeURIComponent(ULTIMEDIA_css_title_background_color);ULTIMEDIA_LOADING_SRC+="&css_title_background_color="+encodeURIComponent(ULTIMEDIA_css_title_background_color)}if(typeof ULTIMEDIA_css_title_widget_uppercase!="undefined"&&ULTIMEDIA_css_title_widget_uppercase!==""){ULTIMEDIA_CODE_SRC+="&css_title_widget_uppercase="+encodeURIComponent(ULTIMEDIA_css_title_widget_uppercase);ULTIMEDIA_LOADING_SRC+="&css_title_widget_uppercase="+encodeURIComponent(ULTIMEDIA_css_title_widget_uppercase)}if(typeof ULTIMEDIA_css_panel_position!="undefined"&&ULTIMEDIA_css_panel_position!==""){ULTIMEDIA_CODE_SRC+="&css_panel_position="+encodeURIComponent(ULTIMEDIA_css_panel_position);ULTIMEDIA_LOADING_SRC+="&css_panel_position="+encodeURIComponent(ULTIMEDIA_css_panel_position)}if(typeof ULTIMEDIA_css_panel_font_size!="undefined"&&ULTIMEDIA_css_panel_font_size!==""){ULTIMEDIA_CODE_SRC+="&css_panel_font_size="+encodeURIComponent(ULTIMEDIA_css_panel_font_size);ULTIMEDIA_LOADING_SRC+="&css_panel_font_size="+encodeURIComponent(ULTIMEDIA_css_panel_font_size)}if(typeof ULTIMEDIA_css_panel_font_color!="undefined"&&ULTIMEDIA_css_panel_font_color!==""){ULTIMEDIA_CODE_SRC+="&css_panel_font_color="+encodeURIComponent(ULTIMEDIA_css_panel_font_color);ULTIMEDIA_LOADING_SRC+="&css_panel_font_color="+encodeURIComponent(ULTIMEDIA_css_panel_font_color)}if(typeof ULTIMEDIA_css_panel_text_align!="undefined"&&ULTIMEDIA_css_panel_text_align!==""){ULTIMEDIA_CODE_SRC+="&css_panel_text_align="+encodeURIComponent(ULTIMEDIA_css_panel_text_align);ULTIMEDIA_LOADING_SRC+="&css_panel_text_align="+encodeURIComponent(ULTIMEDIA_css_panel_text_align)}if(typeof ULTIMEDIA_css_panel_text_uppercase!="undefined"&&ULTIMEDIA_css_panel_text_uppercase!==""){ULTIMEDIA_CODE_SRC+="&css_panel_text_uppercase="+encodeURIComponent(ULTIMEDIA_css_panel_text_uppercase);ULTIMEDIA_LOADING_SRC+="&css_panel_text_uppercase="+encodeURIComponent(ULTIMEDIA_css_panel_text_uppercase)}if(typeof ULTIMEDIA_css_thumb_background_color!="undefined"&&ULTIMEDIA_css_thumb_background_color!==""){ULTIMEDIA_CODE_SRC+="&css_thumb_background_color="+encodeURIComponent(ULTIMEDIA_css_thumb_background_color);ULTIMEDIA_LOADING_SRC+="&css_thumb_background_color="+encodeURIComponent(ULTIMEDIA_css_thumb_background_color)}if(typeof ULTIMEDIA_css_thumb_border_color!="undefined"&&ULTIMEDIA_css_thumb_border_color!==""){ULTIMEDIA_CODE_SRC+="&css_thumb_border_color="+encodeURIComponent(ULTIMEDIA_css_thumb_border_color);ULTIMEDIA_LOADING_SRC+="&css_thumb_border_color="+encodeURIComponent(ULTIMEDIA_css_thumb_border_color)}if(typeof ULTIMEDIA_css_thumb_infos_font_color!="undefined"&&ULTIMEDIA_css_thumb_infos_font_color!==""){ULTIMEDIA_CODE_SRC+="&css_thumb_infos_font_color="+encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_color);ULTIMEDIA_LOADING_SRC+="&css_thumb_infos_font_color="+encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_color)}if(typeof ULTIMEDIA_css_thumb_infos_font!="undefined"&&ULTIMEDIA_css_thumb_infos_font!==""){ULTIMEDIA_CODE_SRC+="&css_thumb_infos_font="+encodeURIComponent(ULTIMEDIA_css_thumb_infos_font);ULTIMEDIA_LOADING_SRC+="&css_thumb_infos_font="+encodeURIComponent(ULTIMEDIA_css_thumb_infos_font)}if(typeof ULTIMEDIA_css_thumb_background_color_hover!="undefined"&&ULTIMEDIA_css_thumb_background_color_hover!==""){ULTIMEDIA_CODE_SRC+="&css_thumb_background_color_hover="+encodeURIComponent(ULTIMEDIA_css_thumb_background_color_hover);ULTIMEDIA_LOADING_SRC+="&css_thumb_background_color_hover="+encodeURIComponent(ULTIMEDIA_css_thumb_background_color_hover)}if(typeof ULTIMEDIA_css_thumb_border_color_hover!="undefined"&&ULTIMEDIA_css_thumb_border_color_hover!==""){ULTIMEDIA_CODE_SRC+="&css_thumb_border_color_hover="+encodeURIComponent(ULTIMEDIA_css_thumb_border_color_hover);ULTIMEDIA_LOADING_SRC+="&css_thumb_border_color_hover="+encodeURIComponent(ULTIMEDIA_css_thumb_border_color_hover)}if(typeof ULTIMEDIA_css_thumb_infos_font_color_hover!="undefined"&&ULTIMEDIA_css_thumb_infos_font_color_hover!==""){ULTIMEDIA_CODE_SRC+="&css_thumb_infos_font_color_hover="+encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_color_hover);ULTIMEDIA_LOADING_SRC+="&css_thumb_infos_font_color_hover="+encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_color_hover)}if(typeof ULTIMEDIA_css_thumb_infos_font_hover!="undefined"&&ULTIMEDIA_css_thumb_infos_font_hover!==""){ULTIMEDIA_CODE_SRC+="&css_thumb_infos_font_hover="+encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_hover);ULTIMEDIA_LOADING_SRC+="&css_thumb_infos_font_hover="+encodeURIComponent(ULTIMEDIA_css_thumb_infos_font_hover)}if(typeof ULTIMEDIA_css_thumb_text_uppercase!="undefined"&&ULTIMEDIA_css_thumb_text_uppercase!==""){ULTIMEDIA_CODE_SRC+="&css_thumb_text_uppercase="+encodeURIComponent(ULTIMEDIA_css_thumb_text_uppercase);ULTIMEDIA_LOADING_SRC+="css_thumb_text_uppercase="+encodeURIComponent(ULTIMEDIA_css_thumb_text_uppercase)}if(typeof ULTIMEDIA_css_list_overflow_x!="undefined"&&ULTIMEDIA_css_list_overflow_x!==""){ULTIMEDIA_CODE_SRC+="&css_list_overflow_x="+encodeURIComponent(ULTIMEDIA_css_list_overflow_x);ULTIMEDIA_LOADING_SRC+="&css_list_overflow_x="+encodeURIComponent(ULTIMEDIA_css_list_overflow_x)}if(typeof ULTIMEDIA_css_list_overflow_y!="undefined"&&ULTIMEDIA_css_list_overflow_y!==""){ULTIMEDIA_CODE_SRC+="&css_list_overflow_y="+encodeURIComponent(ULTIMEDIA_css_list_overflow_y);ULTIMEDIA_LOADING_SRC+="&css_list_overflow_y="+encodeURIComponent(ULTIMEDIA_css_list_overflow_y)}if(typeof ULTIMEDIA_css_list_background_color!="undefined"&&ULTIMEDIA_css_list_background_color!==""){ULTIMEDIA_CODE_SRC+="&css_list_background_color="+encodeURIComponent(ULTIMEDIA_css_list_background_color);ULTIMEDIA_LOADING_SRC+="&css_list_background_color="+encodeURIComponent(ULTIMEDIA_css_list_background_color)}if(typeof ULTIMEDIA_css_photosgallery_selected_border!="undefined"&&ULTIMEDIA_css_photosgallery_selected_border!==""){ULTIMEDIA_CODE_SRC+="&css_photosgallery_selected_border="+encodeURIComponent(ULTIMEDIA_css_photosgallery_selected_border);ULTIMEDIA_LOADING_SRC+="&css_photosgallery_selected_border="+encodeURIComponent(ULTIMEDIA_css_photosgallery_selected_border)}if(typeof ULTIMEDIA_css_photosgallery_nav_background_color!="undefined"&&ULTIMEDIA_css_photosgallery_nav_background_color!==""){ULTIMEDIA_CODE_SRC+="&css_photosgallery_nav_background_color="+encodeURIComponent(ULTIMEDIA_css_photosgallery_nav_background_color);ULTIMEDIA_LOADING_SRC+="&css_photosgallery_nav_background_color="+encodeURIComponent(ULTIMEDIA_css_photosgallery_nav_background_color)}if(typeof ULTIMEDIA_css_photosgallery_button_nav_font_color!="undefined"&&ULTIMEDIA_css_photosgallery_button_nav_font_color!==""){ULTIMEDIA_CODE_SRC+="&css_photosgallery_button_nav_font_color="+encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_font_color);ULTIMEDIA_LOADING_SRC+="&css_photosgallery_button_nav_font_color="+encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_font_color)}if(typeof ULTIMEDIA_css_photosgallery_button_nav_background_color!="undefined"&&ULTIMEDIA_css_photosgallery_button_nav_background_color!==""){ULTIMEDIA_CODE_SRC+="&css_photosgallery_button_nav_background_color="+encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_background_color);ULTIMEDIA_LOADING_SRC+="&css_photosgallery_button_nav_background_color="+encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_background_color)}if(typeof ULTIMEDIA_css_photosgallery_button_nav_font_color_hover!="undefined"&&ULTIMEDIA_css_photosgallery_button_nav_font_color_hover!==""){ULTIMEDIA_CODE_SRC+="&css_photosgallery_button_nav_font_color_hover="+encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_font_color_hover);ULTIMEDIA_LOADING_SRC+="&css_photosgallery_button_nav_font_color_hover="+encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_font_color_hover)}if(typeof ULTIMEDIA_css_photosgallery_button_nav_background_color_hover!="undefined"&&ULTIMEDIA_css_photosgallery_button_nav_background_color_hover!==""){ULTIMEDIA_CODE_SRC+="&css_photosgallery_button_nav_background_color_hover="+encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_background_color_hover);ULTIMEDIA_LOADING_SRC+="css_photosgallery_button_nav_background_color_hover="+encodeURIComponent(ULTIMEDIA_css_photosgallery_button_nav_background_color_hover)}if(typeof ULTIMEDIA_css_footer_font_color!="undefined"&&ULTIMEDIA_css_footer_font_color!==""){ULTIMEDIA_CODE_SRC+="&css_footer_font_color="+encodeURIComponent(ULTIMEDIA_css_footer_font_color);ULTIMEDIA_LOADING_SRC+="&css_footer_font_color="+encodeURIComponent(ULTIMEDIA_css_footer_font_color)}if(typeof ULTIMEDIA_css_footer_text_align!="undefined"&&ULTIMEDIA_css_footer_text_align!==""){ULTIMEDIA_CODE_SRC+="&css_footer_text_align="+encodeURIComponent(ULTIMEDIA_css_footer_text_align);ULTIMEDIA_LOADING_SRC+="&css_title_footer_align="+encodeURIComponent(ULTIMEDIA_css_footer_text_align)}if(typeof ULTIMEDIA_css_background_color!="undefined"&&ULTIMEDIA_css_background_color!==""){ULTIMEDIA_CODE_SRC+="&css_background_color="+encodeURIComponent(ULTIMEDIA_css_background_color);ULTIMEDIA_LOADING_SRC+="&css_background_color="+encodeURIComponent(ULTIMEDIA_css_background_color)}if(typeof ULTIMEDIA_css_background_image!="undefined"&&ULTIMEDIA_css_background_image!==""){ULTIMEDIA_CODE_SRC+="&css_background_image="+encodeURIComponent(ULTIMEDIA_css_background_image);ULTIMEDIA_LOADING_SRC+="&css_background_image="+encodeURIComponent(ULTIMEDIA_css_background_image)}if(typeof ULTIMEDIA_css_background_repeat!="undefined"&&ULTIMEDIA_css_background_repeat!==""){ULTIMEDIA_CODE_SRC+="&css_background_repeat="+encodeURIComponent(ULTIMEDIA_css_background_repeat);ULTIMEDIA_LOADING_SRC+="&css_background_repeat="+encodeURIComponent(ULTIMEDIA_css_background_repeat)}if(typeof ULTIMEDIA_css_background_position!="undefined"&&ULTIMEDIA_css_background_position!==""){ULTIMEDIA_CODE_SRC+="&css_background_position="+encodeURIComponent(ULTIMEDIA_css_background_position);ULTIMEDIA_LOADING_SRC+="&css_background_position="+encodeURIComponent(ULTIMEDIA_css_background_position)}if(typeof ULTIMEDIA_source_logo_brand!="undefined"&&ULTIMEDIA_source_logo_brand!==""){ULTIMEDIA_CODE_SRC+="&source_logo_brand="+encodeURIComponent(ULTIMEDIA_source_logo_brand);ULTIMEDIA_LOADING_SRC+="&source_logo_brand="+encodeURIComponent(ULTIMEDIA_source_logo_brand)}if(typeof ULTIMEDIA_url_logo_brand!="undefined"&&ULTIMEDIA_url_logo_brand!==""){ULTIMEDIA_CODE_SRC+="&url_logo_brand="+encodeURIComponent(ULTIMEDIA_url_logo_brand);ULTIMEDIA_LOADING_SRC+="&url_logo_brand="+encodeURIComponent(ULTIMEDIA_url_logo_brand)}if((typeof(jwplayer)!='undefined')&&(typeof(DTKPlayer)=='undefined')){ULTIMEDIA_CODE_SRC+='&jw=1'}if(typeof ULTIMEDIA_async=="undefined"){ULTIMEDIA_async=true}_ultimedia_needs=new Array;_ultimedia_needs.push("jquery");if(("undefined"==typeof window.jQuery||"undefined"==typeof window.jQuery().tooltipster)&&("undefined"==typeof ULTIMEDIA_layout||ULTIMEDIA_layout!="pix_list"&&ULTIMEDIA_layout!="single"&&ULTIMEDIA_layout!="text_list"&&ULTIMEDIA_layout!="bottom_list"&&ULTIMEDIA_layout!="bottom_list_automoto"&&ULTIMEDIA_layout!="pix_list_right"&&ULTIMEDIA_layout!="pix_list_right_slide"&&ULTIMEDIA_layout!="page_top"&&ULTIMEDIA_layout!="page_top_grazia"&&ULTIMEDIA_layout!="page_top_light"&&ULTIMEDIA_layout!="page_top_header"&&ULTIMEDIA_layout!="page_top_v2")){_ultimedia_needs.push("tooltipster")}if(("undefined"==typeof window.jQuery||"undefined"==typeof window.jQuery().sliderkit)&&ULTIMEDIA_layout!="single"&&ULTIMEDIA_layout!="pix_list"&&ULTIMEDIA_layout!="text_list"&&ULTIMEDIA_layout!="bottom_list"&&ULTIMEDIA_layout!="bottom_list_automoto"&&ULTIMEDIA_layout!="wall_pix"&&ULTIMEDIA_layout!="bottom_wallpix_cinema"&&ULTIMEDIA_layout!="bottom_wallpix_actus"&&ULTIMEDIA_layout!="bottom_wallpix_people"&&ULTIMEDIA_layout!="bottom_wallpix_top_clip_fr"&&ULTIMEDIA_layout!="bottom_wallpix_jv"&&ULTIMEDIA_layout!="wallpix_cine_demo_digiteka"&&ULTIMEDIA_layout!="wallpix_cine_telerama"&&ULTIMEDIA_layout!="pix_list_right"&&ULTIMEDIA_layout!="pix_list_right_slide"&&ULTIMEDIA_layout!="page_top"&&ULTIMEDIA_layout!="page_top_grazia"&&ULTIMEDIA_layout!="page_top_light"&&ULTIMEDIA_layout!="page_top_header"&&ULTIMEDIA_layout!="page_top_v2"){_ultimedia_needs.push("sliderkit")}if(("undefined"==typeof window.jQuery||"undefined"==typeof window.jQuery().jcarousel)&&(ULTIMEDIA_layout=="pix_list_right"||ULTIMEDIA_layout=="pix_list_right_slide"||ULTIMEDIA_layout=="page_top"||ULTIMEDIA_layout=="page_top_grazia"||ULTIMEDIA_layout=="page_top_light"||ULTIMEDIA_layout=="page_top_header"||ULTIMEDIA_layout=="page_top_v2")){_ultimedia_needs.push("jcarousel")}if(_ultimedia_needs.length>0){ULTIMEDIA_CODE_SRC+="&needs="+_ultimedia_needs.join(",")}if(typeof ULTIMEDIA_validated_videos_only!="undefined"&&ULTIMEDIA_validated_videos_only!==""){ULTIMEDIA_CODE_SRC+="&restriction="+encodeURIComponent(ULTIMEDIA_validated_videos_only);ULTIMEDIA_LOADING_SRC+="&restriction="+encodeURIComponent(ULTIMEDIA_validated_videos_only)}if(typeof ULTIMEDIA_target!="undefined"&&ULTIMEDIA_target!==""&&document.getElementById(ULTIMEDIA_target)&&ULTIMEDIA_async===true){ULTIMEDIA_CODE_SRC+="&target="+encodeURIComponent(ULTIMEDIA_target);if(document.readyState=="complete"||ULTIMEDIA_async===false){_ultimedia_script=document.createElement("script");_ultimedia_script.setAttribute("type","text/javascript");var ulti_img=document.getElementById(ULTIMEDIA_target).children[0];if(ulti_img!=undefined&&ulti_img.tagName=="IMG"){ULTIMEDIA_CODE_SRC+="&click_to_play=1";_ultimedia_script.setAttribute("src",ULTIMEDIA_CODE_SRC);var ulti_div=document.createElement("div");ulti_div.id=ULTIMEDIA_target+"_wrapper";ulti_div.style.display="none";document.getElementById(ULTIMEDIA_target).appendChild(ulti_div);document.getElementById(ULTIMEDIA_target+"_wrapper").appendChild(_ultimedia_script)}else{_ultimedia_script.setAttribute("src",ULTIMEDIA_CODE_SRC);document.getElementById(ULTIMEDIA_target).appendChild(_ultimedia_script)}}else{if(typeof _ultimedia_targets=="undefined"){_ultimedia_targets=new Array}_ultimedia_targets[ULTIMEDIA_target]=ULTIMEDIA_CODE_SRC;if(typeof _ultimedia_onload=="undefined"){_ultimedia_onload=function(){_ultimedia_onload_done=true;for(_ultimedia_target in _ultimedia_targets){if(document.getElementById(_ultimedia_target)){_ultimedia_script=document.createElement("script");_ultimedia_script.setAttribute("type","text/javascript");_ultimedia_script.setAttribute("src",_ultimedia_targets[_ultimedia_target]);document.getElementById(_ultimedia_target).appendChild(_ultimedia_script)}}}}if(typeof window.addEventListener!="undefined"){window.addEventListener("load",_ultimedia_onload,false)}else if(typeof document.addEventListener!="undefined"){document.addEventListener("load",_ultimedia_onload,false)}else if(typeof window.attachEvent!="undefined"){window.attachEvent("onload",_ultimedia_onload)}else{if(typeof window.onload=="function"){var _ultimedia_existing_onload=window.onload;window.onload=function(){_ultimedia_existing_onload();_ultimedia_onload()}}else{window.onload=_ultimedia_onload}}if(typeof _ultimedia_onload_check=="undefined"){_ultimedia_onload_done=false;_ultimedia_onload_check=function(){if(document.readyState=="complete"&&!_ultimedia_onload_done){_ultimedia_onload()}else if(!_ultimedia_onload_done){setTimeout("_ultimedia_onload_check()",1e3)}};setTimeout("_ultimedia_onload_check()",1e3)}}}else{ULTIMEDIA_target=typeof ULTIMEDIA_target!="undefined"&&ULTIMEDIA_target!==""?ULTIMEDIA_target:"_ultimedia_widget_wrapper"+(_ultimedia_widget_id!=0?"_"+_ultimedia_widget_id:"");if(!document.getElementById(ULTIMEDIA_target)){document.write('<div id="'+ULTIMEDIA_target+'"></div>')}ULTIMEDIA_CODE_SRC+="&target="+encodeURIComponent(ULTIMEDIA_target);var ulti_img=document.getElementById(ULTIMEDIA_target).children[0];if(ulti_img!=undefined&&ulti_img.tagName=="IMG"){ULTIMEDIA_CODE_SRC+="&click_to_play=1";var ulti_div=document.createElement("div");ulti_div.id=ULTIMEDIA_target+"_wrapper";ulti_div.style.display="none";document.getElementById(ULTIMEDIA_target).appendChild(ulti_div)}if(!document.write("<scr"+'ipt type="text/javascript" src="'+ULTIMEDIA_CODE_SRC+'"></scr'+"ipt>")){var _ultimedia_script=document.createElement("script");_ultimedia_script.setAttribute("type","text/javascript");_ultimedia_script.setAttribute("src",ULTIMEDIA_CODE_SRC);document.getElementById(ULTIMEDIA_target).appendChild(_ultimedia_script)}}if(typeof ULTIMEDIA_param=="undefined"){var ULTIMEDIA_param=new Array}var ULTIMEDIA_param_length=ULTIMEDIA_param.length;ULTIMEDIA_param[ULTIMEDIA_param_length]=ULTIMEDIA_CODE_SRC;ULTIMEDIA_search="";ULTIMEDIA_index="";ULTIMEDIA_mode="";ULTIMEDIA_date="";ULTIMEDIA_host="";ULTIMEDIA_mdtk="";ULTIMEDIA_zone="";ULTIMEDIA_nb="";ULTIMEDIA_urlfacebook="";ULTIMEDIA_ad="";ULTIMEDIA_callback="";ULTIMEDIA_widget_title="";ULTIMEDIA_widget_footer="";ULTIMEDIA_widget_header="";ULTIMEDIA_overlay_title="";ULTIMEDIA_show_tooltips="";ULTIMEDIA_autoplay="";ULTIMEDIA_playlist="";ULTIMEDIA_width="";ULTIMEDIA_height="";ULTIMEDIA_layout="";ULTIMEDIA_default_videolist="";ULTIMEDIA_default_zone="";ULTIMEDIA_default_widget_title="";ULTIMEDIA_css_title_font_color="";ULTIMEDIA_css_title_font="";ULTIMEDIA_css_title_text_align="";ULTIMEDIA_css_title_background_color="";ULTIMEDIA_css_panel_position="";ULTIMEDIA_css_panel_font_size="";ULTIMEDIA_css_panel_font_color="";ULTIMEDIA_css_panel_text_align="";ULTIMEDIA_css_thumb_background_color="";ULTIMEDIA_css_thumb_border_color="";ULTIMEDIA_css_thumb_infos_font_color="";ULTIMEDIA_css_thumb_infos_font="";ULTIMEDIA_css_thumb_background_color_hover="";ULTIMEDIA_css_thumb_border_color_hover="";ULTIMEDIA_css_thumb_infos_font_color_hover="";ULTIMEDIA_css_thumb_infos_font_hover="";ULTIMEDIA_css_list_overflow_x="";ULTIMEDIA_css_list_overflow_y="";ULTIMEDIA_css_list_background_color="";ULTIMEDIA_css_photosgallery_selected_border="";ULTIMEDIA_css_photosgallery_nav_background_color="";ULTIMEDIA_css_photosgallery_button_nav_font_color="";ULTIMEDIA_css_photosgallery_button_nav_background_color="";ULTIMEDIA_css_photosgallery_button_nav_font_color_hover="";ULTIMEDIA_css_photosgallery_button_nav_background_color_hover="";ULTIMEDIA_target="";ULTIMEDIA_css_title_widget_uppercase="";ULTIMEDIA_css_panel_text_uppercase="";ULTIMEDIA_css_thumb_text_uppercase="";ULTIMEDIA_css_footer_font_color="";ULTIMEDIA_css_footer_text_align="";ULTIMEDIA_css_background_color="";ULTIMEDIA_css_background_image="";ULTIMEDIA_css_background_repeat="";ULTIMEDIA_css_background_position="";ULTIMEDIA_source_logo_brand="";ULTIMEDIA_url_logo_brand="";ULTIMEDIA_resize="";ULTIMEDIA_css_header_font="";ULTIMEDIA_css_header_font_color="";ULTIMEDIA_css_header_border="";ULTIMEDIA_interval=0;ULTIMEDIA_limit="";ULTIMEDIA_validated_videos_only=""

