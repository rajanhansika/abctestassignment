package com.abcassignment.pom.util;

public class ABCNewsConstants {

	//paths
	public static final String FIREFOX_DRIVER_EXE = "\\geckodriver.exe";
	public static final String CHROME_DRIVER_EXE = "\\chromedriver.exe";
	public static final String IE_DRIVER_EXE = "\\IEDriverServer.exe";
	public static final String REPORTS_PATH = "\\Reports\\";
	
	//locators
	public static final String JUSTINPAGE_LINK = "//*[@id='n-justin']/a";
	public static final String SET_LOCATION_WEBELEMENT   = "//*[@id='header']/a[1]/div";
	
	//URLs
	public static final String HOMEPAGE_URL = "http://www.abc.net.au/news/";
	public static final String VIDEO_URL_KEY = "http://www.abc.net.au/news/2017-02-09/weatherill-promises-to-intervene-dramatically/8254908";
	public static final String IMAGE_URL_KEY = "http://www.abc.net.au/news/2017-02-10/abc-open-pic-of-the-week/8256256";
	public static final String NAV_URL_KEY = "http://www.abc.net.au/radionational/";
	

	
	//JustInPage Locators
	public static final String TITLE_xpath  = "//*[@id='main_content']/div/div/div[1]/div/ul/li[1]/h3/a";
	public static final String expectedTextKey = "FIFA plays down Russian hooligan violence fears at 2018 World Cup";
	public static final String VERIFYING_TEXT= "//*[@id='main_content']/div/div/div[1]/div/ul/li[1]";
	
	//Video-xpath
	public static final String VIDEO_WEB_ELEMENT = "//*[@id='jwplayer-video-0_display']/div[1]";
	public static final String VIDEO_PLAY_BUTTON = "//*[@id='jwplayer-video-0_display_button_play']";
	
	//Image-xpath
	public static final String IMAGE_WEB_ELEMENT = "//*[@id='main_content']/div[1]/div/div/div/div/ul/li[1]";
	
	//NavigationPageTest xPaths
	public static final String PROGRAMS_HYPERLINK_XPATH = "//*[@id='rn-navigation']/ul/li[2]/a";
	public static final String BIGIDEAS_LINK_XPATH = "//*[@id='rn-programindex']/li[11]/a";
	public static final String RIGHT_ARROW_XPATH = "//*[@id='right-arrow']";
	public static final String LAST_PROGRAM_XPATH = "//*[@id='content']/div[1]/div/div/div[2]/ul/li[19]/a/div/img";
	public static final String HOME_PAGE_XPATH = "//*[@id='rn-navigation']/ul/li[1]/a";
	
	//RadioNationalPage xpaths
	public static final String SHARE_ICON_HOME_URL_KEY = "http://www.abc.net.au/radionational/programs/bigideas/a-fortunate-universe/8076406";
	public static final String DOWNLOAD_AUDIO_TAB_XPATH = "//*[@id='content']/div[1]/div/div/div[1]/ul/li[2]/a";
	public static final String LISTEN_AUDIO_XPATH = "//*[@id='content']/div[1]/div/div/div[1]/ul/li[1]/a";
}
