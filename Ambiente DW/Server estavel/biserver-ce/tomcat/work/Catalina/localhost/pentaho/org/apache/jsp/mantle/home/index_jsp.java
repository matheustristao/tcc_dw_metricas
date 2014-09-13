package org.apache.jsp.mantle.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.pentaho.platform.api.engine.IPluginManager;
import org.pentaho.platform.security.policy.rolebased.actions.RepositoryCreateAction;
import org.pentaho.platform.security.policy.rolebased.actions.AdministerSecurityAction;
import org.pentaho.platform.engine.core.system.PentahoSessionHolder;
import org.pentaho.platform.api.engine.IAuthorizationPolicy;
import org.pentaho.platform.engine.core.system.PentahoSystem;
import java.util.List;

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

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

  boolean canCreateContent = PentahoSystem.get(IAuthorizationPolicy.class, PentahoSessionHolder.getSession()).isAllowed(RepositoryCreateAction.NAME);
  boolean canAdminister = PentahoSystem.get(IAuthorizationPolicy.class, PentahoSessionHolder.getSession()).isAllowed(AdministerSecurityAction.NAME);
  List<String> pluginIds = PentahoSystem.get(IPluginManager.class, PentahoSessionHolder.getSession()).getRegisteredPlugins();

      out.write("\n");
      out.write("<html lang=\"en\" class=\"bootstrap\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <title>Home Page</title>\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("  <!-- Le styles -->\n");
      out.write("  <link href=\"css/home.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  <!-- We need web context for requirejs and css -->\n");
      out.write("  <script type=\"text/javascript\" src=\"webcontext.js?context=mantle&cssOnly=true\"></script>\n");
      out.write("  <script language='JavaScript' type='text/javascript' src='http://admin.brightcove.com/js/BrightcoveExperiences.js'></script>\n");
      out.write("\n");
      out.write("  <!-- Avoid 'console' errors in browsers that lack a console. -->\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    if (!(window.console && console.log)) {\n");
      out.write("      (function() {\n");
      out.write("        var noop = function() {};\n");
      out.write("        var methods = ['assert', 'debug', 'error', 'info', 'log', 'trace', 'warn'];\n");
      out.write("        var length = methods.length;\n");
      out.write("        var console = window.console = {};\n");
      out.write("        while (length--) {\n");
      out.write("          console[methods[length]] = noop;\n");
      out.write("        }\n");
      out.write("      }());\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <!-- Require Home -->\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    var Home = null;\n");
      out.write("    pen.require([\"home/home\", \n");
      out.write("      \"common-ui/util/ContextProvider\"], function(pentahoHome, ContextProvider) {\n");
      out.write("      Home = pentahoHome;      \n");
      out.write("\n");
      out.write("      // Define properties for loading context\n");
      out.write("      var contextConfig = [{\n");
      out.write("        path: \"properties/config\",\n");
      out.write("        post: function(context, loadedMap) {\n");
      out.write("          context.config = loadedMap;\n");
      out.write("        }\n");
      out.write("      }, {\n");
      out.write("        path: \"properties/messages\",\n");
      out.write("        post: function(context, loadedMap) {\n");
      out.write("          context.i18n = loadedMap;\n");
      out.write("        }\n");
      out.write("      }];\n");
      out.write("\n");
      out.write("      // Define permissions\n");
      out.write("      ContextProvider.addProperty(\"canCreateContent\", ");
      out.print(canCreateContent);
      out.write(");\n");
      out.write("      ContextProvider.addProperty(\"canAdminister\", ");
      out.print(canAdminister);
      out.write(");\n");
      out.write("      ContextProvider.addProperty(\"hasAnalyzerPlugin\", ");
      out.print(pluginIds.contains("analyzer"));
      out.write(");\n");
      out.write("      ContextProvider.addProperty(\"hasIRPlugin\", ");
      out.print(pluginIds.contains("pentaho-interactive-reporting"));
      out.write(");\n");
      out.write("      ContextProvider.addProperty(\"hasDashBoardsPlugin\", ");
      out.print(pluginIds.contains("dashboards"));
      out.write(");\n");
      out.write("      ContextProvider.addProperty(\"hasMarketplacePlugin\", ");
      out.print(pluginIds.contains("marketplace"));
      out.write(");\n");
      out.write("      ContextProvider.addProperty(\"hasDataAccess\", false); // default\n");
      out.write("      \n");
      out.write("      // BISERVER-8631 - Manage datasources only available to roles/users with appropriate permissions\n");
      out.write("      var serviceUrl = Home.getUrlBase() + \"plugin/data-access/api/permissions/hasDataAccess\";\n");
      out.write("      Home.getContent(serviceUrl, function(result) {\n");
      out.write("        ContextProvider.addProperty(\"hasDataAccess\", result);\n");
      out.write("        ContextProvider.get(Home.init, contextConfig); // initialize\n");
      out.write("      }, function(error) {\n");
      out.write("        console.log(error);\n");
      out.write("        ContextProvider.get(Home.init, contextConfig); // log error and initialize anyway\n");
      out.write("      });\n");
      out.write("\n");
      out.write("    });\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("  <!--[if lt IE 9]>\n");
      out.write("  <script src=\"bootstrap/js/html5shiv.js\"></script>\n");
      out.write("  <![endif]-->\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body data-spy=\"scroll\" data-target=\".sidebar\">\n");
      out.write("<div class=\"container-fluid main-container\">\n");
      out.write("  <div class=\"row-fluid\">\n");
      out.write("    <div class=\"span3\" id=\"buttonWrapper\">\n");
      out.write("        \n");
      out.write("            \n");
      out.write("      <div class='row-fluid'>        \n");
      out.write("      <script type=\"text/x-handlebars-template\">\n");
      out.write("        <div class=\"well sidebar\">\n");
      out.write("          <button class=\"btn btn-large btn-block\" onclick=\"window.top.mantle_setPerspective('browser.perspective')\">\n");
      out.write("            {{i18n.browse}}\n");
      out.write("          </button>\n");
      out.write("\n");
      out.write("          <!-- Only show create button if user is allowed -->\n");
      out.write("\n");
      out.write("          {{#if canCreateContent}}\n");
      out.write("          <button id=\"btnCreateNew\" class=\"btn btn-large btn-block popover-source\" data-toggle=\"dropdown\"\n");
      out.write("                  data-toggle=\"popover\" data-placement=\"right\" data-html=\"true\" data-container=\"body\">\n");
      out.write("            {{i18n.create_new}}\n");
      out.write("          </button>\n");
      out.write("          {{/if}}\n");
      out.write("\n");
      out.write("          {{#if hasDataAccess}}\n");
      out.write("          <button class=\"btn btn-large btn-block\" onclick=\"window.parent.executeCommand('ManageDatasourcesCommand')\">\n");
      out.write("            {{i18n.manage_datasources}}\n");
      out.write("          </button>\n");
      out.write("          {{/if}}\n");
      out.write("\n");
      out.write("          <button class=\"btn btn-large btn-block\" onclick=\"window.parent.executeCommand('OpenDocCommand')\">\n");
      out.write("            {{i18n.documentation}}\n");
      out.write("          </button>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div style=\"display:none\" id=\"btnCreateNewContent\"></div>\n");
      out.write("      </script>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("         <div class=\"row-fluid\">\n");
      out.write("         <div class='span12'>\n");
      out.write("          <script id=\"recentsTemplate\" type=\"text/x-handlebars-template\" delayCompile=\"true\">\n");
      out.write("            <div id=\"recents\" class=\"well widget-panel\">\n");
      out.write("              <h3>\n");
      out.write("                {{i18n.recents}}\n");
      out.write("              </h3>\n");
      out.write("              <div id=\"recentsSpinner\"></div>\n");
      out.write("              {{#if isEmpty}}\n");
      out.write("              <div class=\"empty-panel content-panel\">\n");
      out.write("                <div class=\"centered\">\n");
      out.write("                  <div class=\"empty-message\">{{i18n.empty_recents_panel_message}}</div>\n");
      out.write("                  <button class=\"pentaho-button\" onclick=\"window.top.mantle_setPerspective('browser.perspective');\">{{i18n.browse}}</button>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              {{else}}\n");
      out.write("              <div id=\"recents-content-panel\" class=\"content-panel\">\n");
      out.write("                <ul class=\"nav nav-tabs nav-stacked\">\n");
      out.write("                  {{#eachRecent recent}}\n");
      out.write("                  <li>\n");
      out.write("                    <a href=\"javascript:Home.openRepositoryFile('{{fullPath}}', 'run')\" title='{{title}}'>\n");
      out.write("                      <div class=\"row-fluid\">\n");
      out.write("                        <div class=\"span10 ellipsis\">\n");
      out.write("                          {{#if xanalyzer}}   <i class=\"pull-left content-icon file-xanalyzer\"/>  {{/if}}\n");
      out.write("                          {{#if xdash}}       <i class=\"pull-left content-icon file-xdash\"/>      {{/if}}\n");
      out.write("                          {{#if xcdf}}        <i class=\"pull-left content-icon file-xcdf\"/>       {{/if}}\n");
      out.write("                          {{#if prpti}}       <i class=\"pull-left content-icon file-prpti\"/>      {{/if}}\n");
      out.write("                          {{#if prpt}}        <i class=\"pull-left content-icon file-prpt\"/>       {{/if}}\n");
      out.write("                          {{#if xaction}}     <i class=\"pull-left content-icon file-xaction\"/>    {{/if}}\n");
      out.write("                          {{#if url}}         <i class=\"pull-left content-icon file-url\"/>        {{/if}}\n");
      out.write("                          {{#if html}}        <i class=\"pull-left content-icon file-html\"/>       {{/if}}\n");
      out.write("                          {{#if cda}}         <i class=\"pull-left content-icon file-cda\"/>        {{/if}}\n");
      out.write("                          {{#if wcdf}}        <i class=\"pull-left content-icon file-wcdf\"/>       {{/if}}\n");
      out.write("                          {{#if unknownType}} <i class=\"pull-left content-icon file-unknown\"/>    {{/if}}\n");
      out.write("                          <span class=\"pad-left\">{{title}}</span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"span2\">\n");
      out.write("                          {{#unless isEmpty}}\n");
      out.write("                          {{#if isFavorite}}\n");
      out.write("                          <i title=\"{{../../../i18n.remove_favorite_tooltip}}\" class=\"pull-right favorite-on\" onclick=\"controller.unmarkRecentAsFavorite('{{fullPath}}'); return false;\"/>\n");
      out.write("                          {{else}}\n");
      out.write("                          <i title=\"{{../../../i18n.add_favorite_tooltip}}\" class=\"pull-right favorite-off\" onclick=\"controller.markRecentAsFavorite('{{fullPath}}', '{{title}}'); return false;\" />\n");
      out.write("                          {{/if}}\n");
      out.write("                          {{/unless}}\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                    </a>\n");
      out.write("                  </li>\n");
      out.write("                  {{/eachRecent}}\n");
      out.write("                </ul>\n");
      out.write("              </div>\n");
      out.write("              {{/if}}\n");
      out.write("            </div>\n");
      out.write("          </script>\n");
      out.write("\n");
      out.write("          <div id=\"recentsContianer\"></div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("      <div class=\"row-fluid\">\n");
      out.write("      \n");
      out.write("\n");
      out.write("        <div class=\"span12\">\n");
      out.write("          <script id=\"favoritesTemplate\" type=\"text/x-handlebars-template\" delayCompile=\"true\">\n");
      out.write("            <div id=\"favorites\" class=\"well widget-panel\">\n");
      out.write("              <h3>\n");
      out.write("                {{i18n.favorites}}\n");
      out.write("              </h3>\n");
      out.write("              <div id=\"favoritesSpinner\"></div>\n");
      out.write("              {{#if isEmpty}}\n");
      out.write("              <div class=\"empty-panel content-panel\">\n");
      out.write("                <div class=\"centered\">\n");
      out.write("                  <div class=\"empty-message\">{{i18n.empty_favorites_panel_message}}</div>\n");
      out.write("                  <button class=\"pentaho-button\" onclick=\"window.top.mantle_setPerspective('browser.perspective')\">{{i18n.browse}}</button>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              {{else}}\n");
      out.write("              <div id=\"favorites-content-panel\" class=\"content-panel\">\n");
      out.write("                <ul class=\"nav nav-tabs nav-stacked\">\n");
      out.write("                  {{#eachFavorite favorites}}\n");
      out.write("                  <li>\n");
      out.write("                    <a href=\"javascript:Home.openRepositoryFile('{{fullPath}}', 'run')\" title='{{title}}'>\n");
      out.write("                      <div class=\"row-fluid\">\n");
      out.write("                        <div class=\"span10 ellipsis\">\n");
      out.write("                          {{#if xanalyzer}}   <i class=\"pull-left content-icon file-xanalyzer\"/>  {{/if}}\n");
      out.write("                          {{#if xdash}}       <i class=\"pull-left content-icon file-xdash\"/>      {{/if}}\n");
      out.write("                          {{#if xcdf}}        <i class=\"pull-left content-icon file-xcdf\"/>       {{/if}}\n");
      out.write("                          {{#if prpti}}       <i class=\"pull-left content-icon file-prpti\"/>      {{/if}}\n");
      out.write("                          {{#if prpt}}        <i class=\"pull-left content-icon file-prpt\"/>       {{/if}}\n");
      out.write("                          {{#if xaction}}     <i class=\"pull-left content-icon file-xaction\"/>    {{/if}}\n");
      out.write("                          {{#if url}}         <i class=\"pull-left content-icon file-url\"/>        {{/if}}\n");
      out.write("                          {{#if html}}        <i class=\"pull-left content-icon file-html\"/>       {{/if}}\n");
      out.write("                          {{#if unknownType}} <i class=\"pull-left content-icon file-unknown\"/>    {{/if}}\n");
      out.write("                          <span class=\"pad-left\">{{title}}</span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"span2\">\n");
      out.write("                          {{#unless isEmpty}}\n");
      out.write("                          <i title=\"{{../../../i18n.remove_favorite_tooltip}}\" class=\"pull-right favorite-on\" onclick=\"controller.unmarkRecentAsFavorite('{{fullPath}}'); return false;\"/>\n");
      out.write("                          {{/unless}}\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                    </a>\n");
      out.write("                  </li>\n");
      out.write("                  {{/eachFavorite}}\n");
      out.write("                </ul>\n");
      out.write("              </div>\n");
      out.write("              {{/if}}\n");
      out.write("            </div>\n");
      out.write("          </script>\n");
      out.write("\n");
      out.write("          <div id=\"favoritesContianer\"></div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div> \n");
      out.write("    <div class=\"span9\" style=\"overflow:visible\">\n");
      out.write("\n");
      out.write("      <div class=\"row-fluid welcome-container\">\n");
      out.write("      \n");
      out.write("      <iframe src=\"content/welcome/index.html\" class='welcome-frame' frameborder=\"0\" scrolling=\"no\"></iframe>\n");
      out.write("            \n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
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
