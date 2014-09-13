package org.apache.jsp.mantle;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import org.pentaho.platform.util.messages.LocaleHelper;
import java.net.URLClassLoader;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import org.owasp.esapi.ESAPI;

public final class Mantle_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

  Locale effectiveLocale = request.getLocale();
  if (!StringUtils.isEmpty(request.getParameter("locale"))) {
    request.getSession().setAttribute("locale_override", request.getParameter("locale"));
        LocaleHelper.parseAndSetLocaleOverride(request.getParameter("locale"));
  } else {
    request.getSession().setAttribute("locale_override", null);
    LocaleHelper.setLocaleOverride(null);
  }
  
  URLClassLoader loader = new URLClassLoader(new URL[] {application.getResource("/mantle/messages/")});
  ResourceBundle properties = ResourceBundle.getBundle("mantleMessages", request.getLocale(), loader);


      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Pentaho User Console</title>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n");
      out.write("\t<meta name=\"gwt:property\" content=\"locale=");
      out.print(ESAPI.encoder().encodeForHTMLAttribute(effectiveLocale.toString()));
      out.write("\">\n");
      out.write("\t<link rel=\"shortcut icon\" href=\"/pentaho-style/favicon.ico\" />\n");
      out.write("\t<link rel='stylesheet' href='mantle/MantleStyle.css'/>\n");
      out.write("    <link rel=\"stylesheet\" href=\"content/data-access/resources/gwt/datasourceEditorDialog.css\"/>\n");
      out.write("    <link rel=\"stylesheet\" href=\"mantle/Widgets.css\" />\n");
      out.write("\t\n");
      out.write("    <script language=\"javascript\" type=\"text/javascript\" src=\"webcontext.js?context=mantle\"></script>\n");
      out.write("        \n");
      out.write("    <script type=\"text/javascript\" src=\"mantle/nativeScripts.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("      if(window.opener && window.opener.reportWindowOpened != undefined){\n");
      out.write("        window.opener.reportWindowOpened();\n");
      out.write("      }\n");
      out.write("\n");
      out.write("  \tvar dataAccessAvailable = false; //Used by child iframes to tell if data access is available.\n");
      out.write("    /* this function is called by the gwt code when initing, if the user has permission */\n");
      out.write("    function initDataAccess(hasAccess) {\n");
      out.write("      dataAccessAvailable = hasAccess;\n");
      out.write("      if(!hasAccess){\n");
      out.write("        return;\n");
      out.write("      }\n");
      out.write("      if(typeof(addMenuItem) == \"undefined\"){\n");
      out.write("        setTimeout(\"initDataAccess(\"+hasAccess+\")\", 1000);\n");
      out.write("        return;\n");
      out.write("      } else {\n");
      out.write("        addMenuItem(\"manageDatasourcesEllipsis\",\"manage_content_menu\", \"ManageDatasourcesCommand\");\n");
      out.write("        addMenuItem(\"newDatasource\",\"new_menu\", \"AddDatasourceCommand\");\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    var datasourceEditorCallback = {\n");
      out.write("      onFinish : function(val, transport) {\n");
      out.write("      },\n");
      out.write("      onError : function(val) {\n");
      out.write("        alert('error:' + val);\n");
      out.write("      },\n");
      out.write("      onCancel : function() {\n");
      out.write("      },\n");
      out.write("      onReady : function() {\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    // This allows content panels to have PUC create new datasources. The iframe requesting\n");
      out.write("    // the new datasource must have a function \"openDatasourceEditorCallback\" on it's window scope\n");
      out.write("    // to be notified of the successful creation of the datasource.\n");
      out.write("    function openDatasourceEditorIFrameProxy(windowReference){\n");
      out.write("    \tvar callbackHelper = function(bool, transport){\n");
      out.write("    \t\twindowReference.openDatasourceEditorCallback(bool, transport);\n");
      out.write("    \t}\n");
      out.write("    \tpho.openDatasourceEditor(new function(){\n");
      out.write("        this.onError = function(err){\n");
      out.write("          alert(err);\n");
      out.write("        }\n");
      out.write("        this.onCancel = function(){\n");
      out.write("        }\n");
      out.write("        this.onReady = function(){\n");
      out.write("        }\n");
      out.write("        this.onFinish = function(bool, transport){\n");
      out.write("          callbackHelper(bool, transport);\n");
      out.write("        }\n");
      out.write("      });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body oncontextmenu=\"return false;\" class=\"pentaho-page-background\">\n");
      out.write("\n");
      out.write("\t<!--\n");
      out.write("\t<div id=\"loading\">\n");
      out.write("    \t\t<div class=\"loading-indicator\">\n");
      out.write("    \t\t\t<img src=\"mantle/large-loading.gif\" width=\"32\" height=\"32\"/>");
      out.print( properties.getString("loadingConsole") );
      out.write("<a href=\"http://www.pentaho.com\"></a><br/>\n");
      out.write("    \t\t\t<span id=\"loading-msg\">");
      out.print( properties.getString("pleaseWait") );
      out.write("</span>\n");
      out.write("    \t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t-->\n");
      out.write("\t\n");
      out.write("\t<!-- Standard -->\n");
      out.write("    <div id=\"pucWrapper\" cellspacing=\"0\" cellpadding=\"0\"  style=\"width: 100%; height: 100%;\">\n");
      out.write("        <div id=\"pucHeader\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("            <div id=\"pucMenuBar\"></div>\n");
      out.write("            <div id=\"pucPerspectives\"></div>\n");
      out.write("            <div id=\"pucToolBar\"></div>\n");
      out.write("\t\t\t<div id=\"pucUserDropDown\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"pucContent\"></div>\n");
      out.write("    </div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    document.getElementById(\"pucWrapper\").style.position = \"absolute\";\n");
      out.write("    document.getElementById(\"pucWrapper\").style.left = \"-5000px\";\n");
      out.write("    pen.require([\"common-ui/util/BusyIndicator\"], function(busy){\n");
      out.write("\n");
      out.write("        busy.show(\"");
      out.print( properties.getString("pleaseWait") );
      out.write("\", \"");
      out.print( properties.getString("loadingConsole") );
      out.write("\", \"pucPleaseWait\");\n");
      out.write("\n");
      out.write("        window.notifyOfLoad = function(area){\n");
      out.write("            var allFramesLoaded = true;\n");
      out.write("            for(var i=0; i<window.frames.length; i++){\n");
      out.write("                if(window.frames[i].document.readyState != \"complete\"){\n");
      out.write("                    allFramesLoaded = false;\n");
      out.write("                    break;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            if(allFramesLoaded){\n");
      out.write("                busy.hide(\"pucPleaseWait\");\n");
      out.write("                document.getElementById(\"pucWrapper\").style.left = \"0\";\n");
      out.write("                document.getElementById(\"pucWrapper\").style.position = \"relative\";\n");
      out.write("            } else {\n");
      out.write("                // check again in a bit\n");
      out.write("                setTimeout(\"notifyOfLoad()\", 300);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        // Remove when notifyOfLoad is called from PUC\n");
      out.write("        setTimeout(function(){\n");
      out.write("            notifyOfLoad();\n");
      out.write("        }, 4000);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\t<!-- Toolbar On Top -->\n");
      out.write("\t<!-- \n");
      out.write("\t<table cellspacing=\"0\" cellpadding=\"0\" style=\"width: 100%; height: 100%\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td id=\"pucToolBar\"></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t<table cellspacing=\"0\" cellpadding=\"0\" >\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<td id=\"pucMenuBar\" style=\"width:100%\"></td>\n");
      out.write("\t\t\t\t\t\t<td id=\"pucPerspectives\"></td>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t</table>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td id=\"pucContent\" style=\"width:100%;height:100%\"></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("\t-->\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t<!-- LOGO -->\n");
      out.write("\t<!--\n");
      out.write("\t<table cellspacing=\"0\" cellpadding=\"0\" style=\"width: 100%; height: 100%\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td colspan=\"2\">\n");
      out.write("\t\t\t\t<table cellspacing=\"0\" cellpadding=\"0\" style=\"width: 100%\">\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<td id=\"pucMenuBar\" style=\"width:100%\"></td>\n");
      out.write("\t\t\t\t\t\t<td id=\"pucPerspectives\"></td>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t</table>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td id=\"pucToolBar\"></td>\n");
      out.write("\t\t\t<td style=\"background-color: white;\">LOGO PANEL</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td id=\"pucContent\" colspan=\"2\" style=\"width:100%;height:100%\"></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("\t-->\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\t<!-- OPTIONAL: include this if you want history support -->\n");
      out.write("\t<iframe id=\"__gwt_historyFrame\" style=\"width:0px;height:0px;border:0;display:none\"></iframe>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("\n");
      out.write("\t<script language='javascript' src='mantle/mantle.nocache.js'></script>\n");
      out.write("\t<script language='javascript' src='content/data-access/resources/gwt/DatasourceEditor.nocache.js'></script>\n");
      out.write("\t\n");
      out.write("</html>\n");
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
