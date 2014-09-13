package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.pentaho.platform.engine.core.system.PentahoSystem;
import org.pentaho.platform.api.engine.IPentahoSession;
import org.pentaho.platform.api.engine.IPluginManager;
import java.util.List;
import org.pentaho.platform.engine.core.system.PentahoSessionHolder;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    \n");
      out.write("    <title>Pentaho Business Analytics</title>    \n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\" src=\"webcontext.js\"></script>\n");
      out.write("\n");
      out.write("\t");

		boolean haveMobileRedirect = false;		
		String ua = request.getHeader("User-Agent").toLowerCase();
		if (!"desktop".equalsIgnoreCase(request.getParameter("mode"))) {		
		  if (ua.contains("ipad") || ua.contains("ipod") || ua.contains("iphone") || ua.contains("android") || "mobile".equalsIgnoreCase(request.getParameter("mode"))) {		
		    IPluginManager pluginManager = PentahoSystem.get(IPluginManager.class, PentahoSessionHolder.getSession()); 
		    List<String> pluginIds = pluginManager.getRegisteredPlugins();
		    for (String id : pluginIds) {
		      String mobileRedirect = (String)pluginManager.getPluginSetting(id, "mobile-redirect", null);
		      if (mobileRedirect != null) {
		        // we have a mobile redirect
			    haveMobileRedirect = true;
			    
      out.write("\n");
      out.write("\t\t\t    <script type=\"text/javascript\">\n");
      out.write("\t\t\t  \t  if(typeof window.top.PentahoMobile != \"undefined\"){\n");
      out.write("\t\t\t  \t\t  window.top.location.reload();\n");
      out.write("\t\t\t  \t  } else {\n");
      out.write("\t\t\t  \t\t  document.write('<META HTTP-EQUIV=\"refresh\" CONTENT=\"0;URL=");
      out.print(mobileRedirect);
      out.write("\">');\n");
      out.write("\t\t\t  \t  }\n");
      out.write("\t\t\t    </script>\n");
      out.write("\t\t\t    ");

			    break;
		      }
		    }
		  }
		  if (!haveMobileRedirect) {
			  
      out.write("\n");
      out.write("\t\t\t  <META HTTP-EQUIV=\"refresh\" CONTENT=\"0;URL=./Home\">\n");
      out.write("\t\t\t  ");

		  }
		}
	
      out.write("\n");
      out.write("\t\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("  </body>\n");
      out.write("</html>");
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
