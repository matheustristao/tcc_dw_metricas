package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.springframework.security.ui.AbstractProcessingFilter;
import org.springframework.security.ui.webapp.AuthenticationProcessingFilter;
import org.springframework.security.ui.savedrequest.SavedRequest;
import org.springframework.security.AuthenticationException;
import org.pentaho.platform.uifoundation.component.HtmlComponent;
import org.pentaho.platform.engine.core.system.PentahoSystem;
import org.pentaho.platform.util.messages.LocaleHelper;
import org.pentaho.platform.api.engine.IPentahoSession;
import org.pentaho.platform.web.http.WebTemplateHelper;
import org.pentaho.platform.api.engine.IUITemplater;
import org.pentaho.platform.api.engine.IPluginManager;
import org.pentaho.platform.web.jsp.messages.Messages;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.commons.lang.StringEscapeUtils;
import org.pentaho.platform.engine.core.system.PentahoSessionHolder;
import org.owasp.esapi.ESAPI;
import org.pentaho.platform.util.ServerTypeUtil;

public final class PUCLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


  // List of request URL strings to look for to send 401

  private List<String> send401RequestList;

  public void jspInit() {
    // super.jspInit();
    send401RequestList = new ArrayList<String>();
    String unauthList = getServletConfig().getInitParameter("send401List"); //$NON-NLS-1$
    if (unauthList == null) {
      send401RequestList.add("AdhocWebService"); //$NON-NLS-1$
    } else {
      StringTokenizer st = new StringTokenizer(unauthList, ","); //$NON-NLS-1$
      String requestStr;
      while (st.hasMoreElements()) {
        requestStr = st.nextToken();
        send401RequestList.add(requestStr.trim());
      }
    }
  }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');

  response.setCharacterEncoding(LocaleHelper.getSystemEncoding());
  String path = request.getContextPath();

  IPentahoSession userSession = PentahoSessionHolder.getSession();
  // SPRING_SECURITY_SAVED_REQUEST_KEY contains the URL the user originally wanted before being redirected to the login page
  // if the requested url is in the list of URLs specified in the web.xml's init-param send401List,
  // then return a 401 status now and don't show a login page (401 means not authenticated)
  Object reqObj = request.getSession().getAttribute(AbstractProcessingFilter.SPRING_SECURITY_SAVED_REQUEST_KEY);
  String requestedURL = "";
  if (reqObj != null) {
    requestedURL = ((SavedRequest) reqObj).getFullRequestUrl();

    String lookFor;
    for (int i=0; i<send401RequestList.size(); i++) {
      lookFor = send401RequestList.get(i);
      if ( requestedURL.indexOf(lookFor) >=0 ) {
        response.sendError(401);
        return;
      }
    }
  }


  boolean loggedIn = request.getRemoteUser() != null && request.getRemoteUser() != "";
  int year = (new java.util.Date()).getYear() + 1900;

  boolean isPlatformServer = ServerTypeUtil.isPlatformServer();
  boolean showUsers = isPlatformServer && Boolean.parseBoolean(PentahoSystem.getSystemSetting("login-show-sample-users-hint", "true"));

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" class=\"bootstrap\">\n");
      out.write("<head>\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("  <title>Pentaho User Console - Login</title>\n");
      out.write("\n");
      out.write("  ");

    String ua = request.getHeader("User-Agent").toLowerCase();
    if (!"desktop".equalsIgnoreCase(request.getParameter("mode"))) {
      if (ua.contains("ipad") || ua.contains("ipod") || ua.contains("iphone") || ua.contains("android") || "mobile".equalsIgnoreCase(request.getParameter("mode"))) {
        IPluginManager pluginManager = PentahoSystem.get(IPluginManager.class, PentahoSessionHolder.getSession());
        List<String> pluginIds = pluginManager.getRegisteredPlugins();
        for (String id : pluginIds) {
          String mobileRedirect = (String)pluginManager.getPluginSetting(id, "mobile-redirect", null);
          if (mobileRedirect != null) {
            // we have a mobile redirect
  
      out.write("\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    if(typeof window.top.PentahoMobile != \"undefined\"){\n");
      out.write("      window.top.location.reload();\n");
      out.write("    } else {\n");
      out.write("      document.write('<META HTTP-EQUIV=\"refresh\" CONTENT=\"0;URL=");
      out.print(mobileRedirect);
      out.write("\">');\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("</head>\n");
      out.write("<BODY>\n");
      out.write("<!-- this div is here for authentication detection (used by mobile, PIR, etc) -->\n");
      out.write("<div style=\"display:none\">j_spring_security_check</div>\n");
      out.write("</BODY>\n");
      out.write("</HTML>\n");

          return;
        }
      }
    }
  }

      out.write("\n");
      out.write("\n");
      out.write("<meta name=\"gwt:property\" content=\"locale=");
      out.print(ESAPI.encoder().encodeForHTMLAttribute(request.getLocale().toString()));
      out.write("\">\n");
      out.write("<link rel=\"shortcut icon\" href=\"/pentaho-style/favicon.ico\" />\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("  #login-background,\n");
      out.write("  #loginError.pentaho-dialog,\n");
      out.write("  #systemDown.pentaho-dialog,\n");
      out.write("  #login-footer {\n");
      out.write("    display: none;\n");
      out.write("  }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"webcontext.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("<script src=\"bootstrap/js/html5shiv.js\"></script>\n");
      out.write("<![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"pentaho-page-background\">\n");
      out.write("<div id=\"login-wrapper\">\n");
      out.write("  <div id=\"login-background\">\n");
      out.write("    <div id=\"login-logo\"></div>\n");
      out.write("\n");
      out.write("    <div id=\"login-form-container\">\n");
      out.write("      <div id=\"animate-wrapper\">\n");
      out.write("        <h1>");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.TITLE"));
      out.write("</h1>\n");
      out.write("        <form name=\"login\" id=\"login\" action=\"j_spring_security_check\" method=\"POST\">\n");
      out.write("          <div class=\"row-fluid nowrap\">\n");
      out.write("            <div class=\"input-container\">\n");
      out.write("              <label>");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.USERNAME"));
      out.write("</label>\n");
      out.write("              <input id=\"j_username\" name=\"j_username\" type=\"text\" placeholder=\"\" autocomplete=\"off\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"input-container\">\n");
      out.write("              <label>");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.PASSWORD"));
      out.write("</label>\n");
      out.write("              <input id=\"j_password\" name=\"j_password\" type=\"password\" placeholder=\"\" autocomplete=\"off\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"input-container\">\n");
      out.write("              <label>&nbsp;</label>\n");
      out.write("              <button type=\"submit\" class=\"btn\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.LOGIN"));
      out.write("</button>\n");
      out.write("              <input type=\"hidden\" name=\"locale\" value=\"en_US\">\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div id=\"eval-users-toggle-container\">\n");
      out.write("            ");

              if (showUsers) {
            
      out.write("\n");
      out.write("            <div id=\"eval-users-toggle\" onClick=\"toggleEvalPanel()\">\n");
      out.write("              <div>");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.EVAL_LOGIN"));
      out.write("</div>\n");
      out.write("                <div id=\"eval-arrow\" class=\"closed\"></div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("            &nbsp;\n");
      out.write("            ");

              }
            
      out.write("\n");
      out.write("          </div>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div class=\"row-fluid\">\n");
      out.write("        <div id=\"evaluationPanel\" class=\"span10 row-fluid\">\n");
      out.write("          <div id=\"role-admin-panel\" class=\"span6 well\">\n");
      out.write("            <div class=\"login-role\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.ADMIN_USER"));
      out.write("</div>\n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("              <div class=\"span6 login-label\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.USERNAME"));
      out.write("</div>\n");
      out.write("              <div class=\"span6 login-value\">Admin</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("              <div class=\"span6 login-label\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.PASSWORD"));
      out.write("</div>\n");
      out.write("              <div class=\"span6 login-value\">password</div>\n");
      out.write("            </div>\n");
      out.write("            <button class=\"btn\" onClick=\"loginAs('Admin', 'password');\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.GO"));
      out.write("</button>\n");
      out.write("          </div>\n");
      out.write("          <div id=\"role-business-user-panel\" class=\"span6 well \">\n");
      out.write("            <div class=\"login-role\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.BUSINESS_USER"));
      out.write("</div>\n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("              <div class=\"span6 login-label\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.USERNAME"));
      out.write("</div>\n");
      out.write("              <div class=\"span6 login-value\">Suzy</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("              <div class=\"span6 login-label\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.PASSWORD"));
      out.write("</div>\n");
      out.write("              <div class=\"span6 login-value\">password</div>\n");
      out.write("            </div>\n");
      out.write("            <button class=\"btn\" onClick=\"loginAs('Suzy', 'password');\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.GO"));
      out.write("</button>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div id=\"login-footer-wrapper\">\n");
      out.write("    <div id=\"login-footer\" class=\"beforeSlide\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.COPYRIGHT", String.valueOf(year)));
      out.write("</div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"loginError\" class=\"pentaho-dialog\">\n");
      out.write("  <div class=\"dialogTopCenterInner\">\n");
      out.write("    <div class=\"Caption\">\n");
      out.write("      ");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.ERROR.CAPTION"));
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"dialogMiddleCenterInner\">\n");
      out.write("    <div class=\"dialog-content pentaho-padding-sm\">\n");
      out.write("      ");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.ERROR"));
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"dialogMBottomCenterInner\">\n");
      out.write("    <div class=\"button-panel\">\n");
      out.write("      <button class=\"btn pull-right\" onclick=\"document.getElementById('loginError').style.display='none'\">");
      out.print(Messages.getInstance().getString("UI.PUC.LOGIN.OK"));
      out.write("</button>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("  ");

  if (showUsers) {
  
      out.write("\n");
      out.write("\n");
      out.write("  function toggleEvalPanel() {\n");
      out.write("    var evaluationPanel = $(\"#evaluationPanel\");\n");
      out.write("    evaluationPanel.toggleClass(\"afterSlide\");\n");
      out.write("    $(\"#eval-arrow\").toggleClass(\"closed\");\n");
      out.write("  }\n");
      out.write("  ");

  }
  
      out.write("\n");
      out.write("\n");
      out.write("  function bounceToReturnLocation() {\n");
      out.write("    // pass\n");
      out.write("    var locale = document.login.locale.value;\n");
      out.write("\n");
      out.write("    var returnLocation = '");
      out.print(ESAPI.encoder().encodeForJavaScript(requestedURL));
      out.write("';\n");
      out.write("\n");
      out.write("    if (returnLocation != '' && returnLocation != null) {\n");
      out.write("      window.location.href = returnLocation;\n");
      out.write("    } else {\n");
      out.write("      window.location.href = window.location.href.replace(\"Login\", \"Home\") + \"?locale=\" + locale;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  function doLogin() {\n");
      out.write("\n");
      out.write("    // if we have a valid session and we attempt to login on top of it, the server\n");
      out.write("    // will actually log us out and will not log in with the supplied credentials, you must\n");
      out.write("    // login again. So instead, if they're already logged in, we bounce out of here to\n");
      out.write("    // prevent confusion.\n");
      out.write("    if (");
      out.print(loggedIn);
      out.write(") {\n");
      out.write("      bounceToReturnLocation();\n");
      out.write("      return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    jQuery.ajax({\n");
      out.write("      type: \"POST\",\n");
      out.write("      url: \"j_spring_security_check\",\n");
      out.write("      dataType: \"text\",\n");
      out.write("      data: $(\"#login\").serialize(),\n");
      out.write("\n");
      out.write("      error:function (xhr, ajaxOptions, thrownError){\n");
      out.write("        if (xhr.status == 404) {\n");
      out.write("          // if we get a 404 it means login was successful but intended resource does not exist\n");
      out.write("          // just let it go - let the user get the 404\n");
      out.write("          bounceToReturnLocation();\n");
      out.write("          return;\n");
      out.write("        }\n");
      out.write("        //Fix for BISERVER-7525\n");
      out.write("        //parsereerror caused by attempting to serve a complex document like a prd report in any presentation format like a .ppt\n");
      out.write("        //does not necesarly mean that there was a failure in the login process, status is 200 so just let it serve the archive to the web browser.\n");
      out.write("        if (xhr.status == 200 && thrownError == 'parsererror') {\n");
      out.write("          document.getElementById(\"j_password\").value = \"\";\n");
      out.write("          bounceToReturnLocation();\n");
      out.write("          return;\n");
      out.write("        }\n");
      out.write("        // fail\n");
      out.write("        $(\"#loginError\").show();\n");
      out.write("      },\n");
      out.write("\n");
      out.write("      success:function(data, textStatus, jqXHR){\n");
      out.write("        if (data.indexOf(\"j_spring_security_check\") != -1) {\n");
      out.write("          // fail\n");
      out.write("          $(\"#loginError\").show();\n");
      out.write("          return false;\n");
      out.write("        } else {\n");
      out.write("          document.getElementById(\"j_password\").value = \"\";\n");
      out.write("          bounceToReturnLocation();\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("    });\n");
      out.write("    return false;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  function loginAs (username, password) {\n");
      out.write("    $(\"#j_username\").attr(\"value\", username);\n");
      out.write("    $(\"#j_password\").attr(\"value\", password);\n");
      out.write("    doLogin();\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  $(document).ready(function(){\n");
      out.write("    $(\"#login\").submit(doLogin);\n");
      out.write("\n");
      out.write("    if (");
      out.print(loggedIn);
      out.write(") {\n");
      out.write("      bounceToReturnLocation();\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("    $(\"#login-background\").fadeIn(1000, function() {\n");
      out.write("      $(\"#login-logo\").addClass(\"afterSlide\");\n");
      out.write("\n");
      out.write("      $(\"#animate-wrapper\").addClass(\"afterSlide\");\n");
      out.write("      $(\"#j_username\").focus();\n");
      out.write("\n");
      out.write("      $(\"#login-footer\").addClass(\"afterSlide\");\n");
      out.write("\n");
      out.write("    });\n");
      out.write("\n");
      out.write("\n");
      out.write("  });\n");
      out.write("</script>\n");
      out.write("</body>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
