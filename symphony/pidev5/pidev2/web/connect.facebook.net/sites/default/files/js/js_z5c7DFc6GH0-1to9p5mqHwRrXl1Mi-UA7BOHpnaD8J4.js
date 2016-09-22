/*
 * Realtime Facebook Ignite Plugin
 * Version: 1.0
 *
 * Author: Nick Rivers
 * http://blueprintinteractive.com
 *
 *
 * Changelog: 
 * Version: 1.0
 *
 */

(function($){
$(document).ready(function(){
  	var settings = { // Defaults
		'url' : Drupal.settings.facebooktrafficdriver.url,
		'required' : Drupal.settings.facebooktrafficdriver.required,
		'stream' : Drupal.settings.facebooktrafficdriver.stream,
		'headline' : Drupal.settings.facebooktrafficdriver.headline,
		'descr' : Drupal.settings.facebooktrafficdriver.descr
    };

	var content = "<h1>"+settings.headline+"</h1><p>"+settings.descr+"</p>";   

	function setCookie(c_name,value,exdays) {
		var exdate=new Date();
		exdate.setDate(exdate.getDate() + exdays);
		var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
		document.cookie=c_name + "=" + c_value;
	}
	
	function getCookie(c_name) {
	var i,x,y,ARRcookies=document.cookie.split(";");
	for (i=0;i<ARRcookies.length;i++)
	  {
	  x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
	  y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
	  x=x.replace(/^\s+|\s+$/g,"");
	  if (x==c_name)
	    {
	    return unescape(y);
	    }
	  }
	}
	
	var current_date = new Date;
	var cookie_year = current_date.getFullYear () + 1;
	var cookie_month = current_date.getMonth ();
	var cookie_day = current_date.getDate ();
	
	function centerS(cur) {
		var cur = cur;		
	    cur.css("position","absolute");
	    cur.css("top", ( $(window).height() - cur.height() ) / 2+$(window).scrollTop() + "px");
	    cur.css("left", ( $(window).width() - cur.width() ) / 2+$(window).scrollLeft() + "px");
	    return this;
	}
	
	function addCommas(nStr)
	{
		nStr += '';
		x = nStr.split('.');
		x1 = x[0];
		x2 = x.length > 1 ? '.' + x[1] : '';
		var rgx = /(\d+)(\d{3})/;
		while (rgx.test(x1)) {
			x1 = x1.replace(rgx, '$1' + ',' + '$2');
		}
		return x1 + x2;
	}
	
	var fbcookie = getCookie("liked");
	
	function implementBuild() {
		var a=$(document).height();
		var b=$(window).width();
		var popuphtml = '<div id="facebookignitemask"></div><div id="facebookignite"></div>';
		$('body').append(popuphtml);
		$("#facebookignitemask").css({width:b,height:a});
		$("#facebookignitemask").fadeTo(600,0.6);

		$('#facebookignite').css('width' , 600);
		$('#facebookignite').css('height' , 370);
		centerS($("#facebookignite"));

		$("#facebookignite").html('<div class="modalnav"></div><div id="facebookignitecontent"><div id="lglikes"></div><div id="clicker"></div><div class="vcontent">'+content+'</div></div>');
		$("#facebookignite").show();	
		$("#clicker").append($("#fbLikeButton"));
		$('.modalnav').hide();


		FB.api({
		    method: 'fql.query',
		    query: "SELECT share_count, like_count FROM link_stat WHERE url='"+settings.url+"'"
		}, function(data) {
		    $("#lglikes").append("<br/><br/><p>"+addCommas(data[0]['like_count'])+"</p><br/><br/>");
		    }
		);

		if (settings.required == 0) {
			$('.modalnav').show();
			$('.modalnav').live('click', function(){
				$('#facebookignitemask').fadeOut("slow");
				$('#facebookignite').fadeOut("slow");
				$('.modalnav').fadeOut("slow");
			});
		}

		FB.Event.subscribe('edge.create', function(href, response) {
			if (settings.required == 1) {
				$('#facebookignitemask').fadeOut("slow");
				$('#facebookignite').fadeOut("slow");
				$('.modalnav').fadeOut("slow");
			}
			if (settings.stream == 0) {
				FB.api({
				    method: 'fql.query',
				    query: "SELECT share_count, like_count FROM link_stat WHERE url='"+settings.url+"'"
				}, function(data) {
				    $("#lglikes p").html(addCommas(data[0]['like_count']));
				    }
				);
			}
			setCookie("liked", "yes", cookie_year, cookie_month, cookie_day );
		});

		FB.Event.subscribe('edge.remove', function(href) {
			if (settings.required == 1) {
				alert("Please like our page to access content!");
			}
			if (settings.stream == 0) {
				FB.api({
				    method: 'fql.query',
				    query: "SELECT share_count, like_count FROM link_stat WHERE url='"+settings.url+"'"
				}, function(data) {
				    $("#lglikes p").html(addCommas(data[0]['like_count']));
				    }
				);
			}
			setCookie("liked", "no", cookie_year, cookie_month, cookie_day );
		});

	   if (settings.stream == 1) {
	       setInterval(function() {
		      	FB.api({
				    method: 'fql.query',
				    query: "SELECT share_count, like_count FROM link_stat WHERE url='"+settings.url+"'"
				}, function(data) {
				    $("#lglikes p").html(addCommas(data[0]['like_count']));
				    }
				);
		   }, 2000);
		   $.ajaxSetup({ cache: false });
	   }
	}
	
	if (settings.required == 1) {
		if (fbcookie != "yes") {
			implementBuild();
		} else {
			$("#fbLikeButton").hide();
		}
	} else {
		implementBuild();
	}
});
})(jQuery);;
(function ($) {

$(document).ready(function() {

  // Expression to check for absolute internal links.
  var isInternal = new RegExp("^(https?):\/\/" + window.location.host, "i");

  // Attach onclick event to document only and catch clicks on all elements.
  $(document.body).click(function(event) {
    // Catch the closest surrounding link of a clicked element.
    $(event.target).closest("a,area").each(function() {

      var ga = Drupal.settings.googleanalytics;
      // Expression to check for special links like gotwo.module /go/* links.
      var isInternalSpecial = new RegExp("(\/go\/.*)$", "i");
      // Expression to check for download links.
      var isDownload = new RegExp("\\.(" + ga.trackDownloadExtensions + ")$", "i");

      // Is the clicked URL internal?
      if (isInternal.test(this.href)) {
        // Skip 'click' tracking, if custom tracking events are bound.
        if ($(this).is('.colorbox')) {
          // Do nothing here. The custom event will handle all tracking.
        }
        // Is download tracking activated and the file extension configured for download tracking?
        else if (ga.trackDownload && isDownload.test(this.href)) {
          // Download link clicked.
          var extension = isDownload.exec(this.href);
          _gaq.push(["_trackEvent", "Downloads", extension[1].toUpperCase(), this.href.replace(isInternal, '')]);
        }
        else if (isInternalSpecial.test(this.href)) {
          // Keep the internal URL for Google Analytics website overlay intact.
          _gaq.push(["_trackPageview", this.href.replace(isInternal, '')]);
        }
      }
      else {
        if (ga.trackMailto && $(this).is("a[href^='mailto:'],area[href^='mailto:']")) {
          // Mailto link clicked.
          _gaq.push(["_trackEvent", "Mails", "Click", this.href.substring(7)]);
        }
        else if (ga.trackOutbound && this.href.match(/^\w+:\/\//i)) {
          if (ga.trackDomainMode == 2 && isCrossDomain(this.hostname, ga.trackCrossDomains)) {
            // Top-level cross domain clicked. document.location is handled by _link internally.
            event.preventDefault();
            _gaq.push(["_link", this.href]);
          }
          else {
            // External link clicked.
            _gaq.push(["_trackEvent", "Outbound links", "Click", this.href]);
          }
        }
      }
    });
  });

  // Colorbox: This event triggers when the transition has completed and the
  // newly loaded content has been revealed.
  $(document).bind("cbox_complete", function() {
    var href = $.colorbox.element().attr("href");
    if (href) {
      _gaq.push(["_trackPageview", href.replace(isInternal, '')]);
    }
  });

});

/**
 * Check whether the hostname is part of the cross domains or not.
 *
 * @param string hostname
 *   The hostname of the clicked URL.
 * @param array crossDomains
 *   All cross domain hostnames as JS array.
 *
 * @return boolean
 */
function isCrossDomain(hostname, crossDomains) {
  /**
   * jQuery < 1.6.3 bug: $.inArray crushes IE6 and Chrome if second argument is
   * `null` or `undefined`, http://bugs.jquery.com/ticket/10076,
   * https://github.com/jquery/jquery/commit/a839af034db2bd934e4d4fa6758a3fed8de74174
   *
   * @todo: Remove/Refactor in D8
   */
  if (!crossDomains) {
    return false;
  }
  else {
    return $.inArray(hostname, crossDomains) > -1 ? true : false;
  }
}

})(jQuery);
;
