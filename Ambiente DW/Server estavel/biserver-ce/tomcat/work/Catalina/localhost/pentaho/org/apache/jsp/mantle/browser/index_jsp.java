package org.apache.jsp.mantle.browser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

      out.write("<!DOCTYPE html>\n");
      out.write("\n");

    String userName = PentahoSessionHolder.getSession().getName();

      out.write("\n");
      out.write("<html lang=\"en\"  class=\"bootstrap\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\" class=\"bootstrap\">\n");
      out.write("    <title>Browse Files</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("    <!-- Le styles -->\n");
      out.write("    <link href=\"css/browser.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- We need web context for requirejs and css -->\n");
      out.write("    <script type=\"text/javascript\" src=\"webcontext.js?context=mantle&cssOnly=true\"></script>\n");
      out.write("\n");
      out.write("    <!-- Avoid 'console' errors in browsers that lack a console. -->\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("      if (!(window.console && console.log)) {\n");
      out.write("        (function() {\n");
      out.write("          var noop = function() {};\n");
      out.write("          var methods = ['assert', 'debug', 'error', 'info', 'log', 'trace', 'warn'];\n");
      out.write("          var length = methods.length;\n");
      out.write("          var console = window.console = {};\n");
      out.write("          while (length--) {\n");
      out.write("            console[methods[length]] = noop;\n");
      out.write("          }\n");
      out.write("        }());\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <!-- Require File Browser -->\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        function openRepositoryFile(path, mode) {\n");
      out.write("            if(!path) {\n");
      out.write("                return;\n");
      out.write("            }\n");
      out.write("            if(!mode) {\n");
      out.write("                mode = \"edit\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // show the opened perspective\n");
      out.write("            var extension = path.split(\".\").pop();\n");
      out.write("\n");
      out.write("            if(!($(\"body\").hasClass(\"IE\") && extension == \"pdf\")){\n");
      out.write("                parent.mantle_setPerspective('opened.perspective');\n");
      out.write("            }\n");
      out.write("            window.parent.mantle_openRepositoryFile(path, mode);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        var FileBrowser = null;\n");
      out.write("\n");
      out.write("        function initBrowser(canDownload, showHiddenFiles, showDescriptions, canPublish){\n");
      out.write("            pen.require([\"js/browser\"], function(pentahoFileBrowser) {\n");
      out.write("                FileBrowser = pentahoFileBrowser;\n");
      out.write("                FileBrowser.setOpenFileHandler(openRepositoryFile);\n");
      out.write("                FileBrowser.setContainer($(\"#fileBrowser\"));\n");
      out.write("                FileBrowser.setShowHiddenFiles(showHiddenFiles);\n");
      out.write("                FileBrowser.setShowDescriptions(showDescriptions);\n");
      out.write("                FileBrowser.setCanDownload(canDownload);\n");
      out.write("\t\t\t\tFileBrowser.setCanPublish(canPublish);\n");
      out.write("                FileBrowser.update(window.top.HOME_FOLDER);\n");
      out.write("\n");
      out.write("                if(window.top.mantle_addHandler == undefined) return;\n");
      out.write("\n");
      out.write("                window.top.mantle_addHandler(\"ShowHiddenFilesEvent\", function(event){\n");
      out.write("                    if(event.value != undefined){\n");
      out.write("                        FileBrowser.setShowHiddenFiles(event.value);\n");
      out.write("                        FileBrowser.update(window.top.HOME_FOLDER);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                window.top.mantle_addHandler(\"ShowDescriptionsEvent\", function(event){\n");
      out.write("                    if(event.value != undefined){\n");
      out.write("                        FileBrowser.updateShowDescriptions(event.value);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("\n");
      out.write("                // refresh file list on successful delete\n");
      out.write("                window.top.mantle_addHandler(\"SolutionFileActionEvent\", function(event){\n");
      out.write("                    if(event.action.indexOf('DeleteFileCommand') >= 0 ||\n");
      out.write("                            (event.action.indexOf('RestoreFileCommand') >= 0)||\n");
      out.write("                            (event.action.indexOf('DeletePermanentFileCommand')>= 0)){\n");
      out.write("                        if(event.message == 'Success'){\n");
      out.write("                            FileBrowser.updateData(); // refresh file list\n");
      out.write("                            FileBrowser.update(FileBrowser.fileBrowserModel.getFolderClicked().attr(\"path\"));\n");
      out.write("                        }\n");
      out.write("                        else{\n");
      out.write("                            window.top.mantle_showMessage('Error', event.message);\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                window.top.mantle_addHandler(\"SolutionFileActionEvent\", function(event){\n");
      out.write("                    if((event.action.indexOf('ScheduleHelper') >= 0)    ||\n");
      out.write("                            (event.action.indexOf('ShareFileCommand') >= 0)){\n");
      out.write("                        if(event.message == 'Open' || event.message == 'Success'){\n");
      out.write("                            window.top.mantle_setPerspective('browser.perspective'); // change to browse perspective\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                // refresh folder list on create new folder / delete folder / import\n");
      out.write("                window.top.mantle_addHandler(\"SolutionFolderActionEvent\", function(event){\n");
      out.write("                    if(event.action.indexOf('NewFolderCommand') >= 0   ||\n");
      out.write("                            event.action.indexOf('DeleteFolderCommand') >= 0 ||\n");
      out.write("                            event.action.indexOf('ImportFileCommand') >= 0   ||\n");
      out.write("                            event.action.indexOf('PasteFilesCommand') >= 0   ||\n");
      out.write("                            event.action.indexOf('DeleteFolderCommand') >= 0 ) {\n");
      out.write("                        if(event.message == 'Success'){\n");
      out.write("                            if(FileBrowser.fileBrowserModel.getFolderClicked()){\n");
      out.write("\n");
      out.write("                                //Refresh folders to parent path if deleting a folder\n");
      out.write("                                if((event.action.indexOf('DeleteFolderCommand')>= 0)){\n");
      out.write("                                    var path=FileBrowser.fileBrowserModel.getFolderClicked().attr(\"path\");\n");
      out.write("                                    var parentPath= path.substring(0, path.lastIndexOf(\"/\"));\n");
      out.write("                                    FileBrowser.update(parentPath); // refresh folder list\n");
      out.write("                                }\n");
      out.write("                                //Restore to last clicked folder path for all other actions\n");
      out.write("                                else {\n");
      out.write("                                    FileBrowser.update(FileBrowser.fileBrowserModel.getFolderClicked().attr(\"path\")); // refresh folder list\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                            //If no last clicked folder, restore to home folder\n");
      out.write("                            else{\n");
      out.write("                                FileBrowser.update(window.top.HOME_FOLDER);\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        else{\n");
      out.write("                            window.top.mantle_showMessage('Error', event.message);\n");
      out.write("                        }\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            window.top.mantle_addHandler(\"GenericEvent\", function(paramJson){\n");
      out.write("          if(paramJson.eventSubType == \"OpenFolderEvent\"){\n");
      out.write("            FileBrowser.openFolder(paramJson.stringParam);\n");
      out.write("          }\n");
      out.write("          else if(paramJson.eventSubType == \"RefreshBrowsePerspectiveEvent\"){\n");
      out.write("            FileBrowser.update(window.top.HOME_FOLDER); // refresh folder list\n");
      out.write("          }\n");
      out.write("          else if(paramJson.eventSubType == \"RefreshFolderEvent\"){\n");
      out.write("            FileBrowser.update(paramJson.stringParam); // refresh specified folder\n");
      out.write("          }\n");
      out.write("          else if(paramJson.eventSubType == \"RefreshCurrentFolderEvent\"){\n");
      out.write("            FileBrowser.updateData();\n");
      out.write("          }\n");
      out.write("          else if(paramJson.eventSubType == \"ImportDialogEvent\"){\n");
      out.write("            FileBrowser.update(FileBrowser.fileBrowserModel.getFolderClicked().attr(\"path\")); // refresh folder list\n");
      out.write("          }\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function checkDownload() {\n");
      out.write("            $.ajax({\n");
      out.write("                url: CONTEXT_PATH + \"api/authorization/action/isauthorized?authAction=org.pentaho.security.administerSecurity\",\n");
      out.write("                type: \"GET\",\n");
      out.write("                async: true,\n");
      out.write("                success: function(response){\n");
      out.write("                    checkShowHiddenFiles(response == \"true\");\n");
      out.write("                },\n");
      out.write("                error: function(response){\n");
      out.write("                \tcheckShowHiddenFiles(false);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function checkShowHiddenFiles(canDownload){\n");
      out.write("            $.ajax({\n");
      out.write("                url: CONTEXT_PATH + \"api/user-settings/MANTLE_SHOW_HIDDEN_FILES\",\n");
      out.write("                type: \"GET\",\n");
      out.write("                async: true,\n");
      out.write("                success: function(response){\n");
      out.write("                    checkShowDescriptions(canDownload, response == \"true\");\n");
      out.write("                },\n");
      out.write("                error: function(response){\n");
      out.write("                    checkShowDescriptions(canDownload, false);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function checkShowDescriptions(canDownload, showHiddenFiles){\n");
      out.write("            $.ajax({\n");
      out.write("                url: CONTEXT_PATH + \"api/user-settings/MANTLE_SHOW_DESCRIPTIONS_FOR_TOOLTIPS\",\n");
      out.write("                type: \"GET\",\n");
      out.write("                async: true,\n");
      out.write("                success: function(response){\n");
      out.write("                    checkPublish(canDownload, showHiddenFiles, (response == \"true\"));\n");
      out.write("                },\n");
      out.write("                error: function(response){\n");
      out.write("                    checkPublish(canDownload, showHiddenFiles, false);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function checkPublish(canDownload, showHiddenFiles, showDescriptions){\n");
      out.write("            $.ajax({\n");
      out.write("                url: CONTEXT_PATH + \"api/authorization/action/isauthorized?authAction=org.pentaho.security.administerSecurity\",\n");
      out.write("                type: \"GET\",\n");
      out.write("                async: true,\n");
      out.write("                success: function(response){\n");
      out.write("                    initBrowser(canDownload, showHiddenFiles, showDescriptions, (response == \"true\"));\n");
      out.write("                },\n");
      out.write("                error: function(response){\n");
      out.write("                    initBrowser(canDownload, showHiddenFiles, showDescriptions, false);\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("\t\t\n");
      out.write("        //init component\n");
      out.write("        checkDownload();\n");
      out.write("\n");
      out.write("        function openFolder(path){\n");
      out.write("\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("    <script src=\"bootstrap/js/html5shiv.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body data-spy=\"scroll\" data-target=\".sidebar\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container-fluid main-container fill-absolute\">\n");
      out.write("    <div id=\"fileBrowser\" class=\"row-fluid fill-absolute\">\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- libs -->\n");
      out.write("    <script type=\"text/javascript\" src=\"lib/jquery/jquery-1.9.1.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"lib/underscore/underscore-min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"lib/backbone/backbone.js\"></script>\n");
      out.write("</div>\n");
      out.write("</body>\n");
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
