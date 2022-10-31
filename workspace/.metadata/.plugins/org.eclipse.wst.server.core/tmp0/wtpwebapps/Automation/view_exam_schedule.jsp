<%@ page language="java" import="java.util.*" import="java.sql.*" import="com.auto.bean.*" import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<head>
    <title>Admin</title>
	<link rel="shortcut icon" href="img/favicon.ico" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	
    <script src="js/prototype.js" type="text/javascript"></script>
    <script src="js/events.js" type="text/javascript"></script>
    <script src="js/tabs.js" type="text/javascript"></script>
   
     
	 <link type="text/css" rel="stylesheet" href="css/admin_reset.css" media="all"></link>
    <link type="text/css" rel="stylesheet" href="css/admin_boxes.css" media="all"></link>
    <link type="text/css" rel="stylesheet" href="css/admin_menu.css" media="screen, projection"></link>
  



  
</head>

<body id="html-body">

	<div class="wrapper">
       
       <jsp:include page="user_header.jsp"></jsp:include>
		
		
		
	
		
        		<div class="middle" id="anchor-content">
            <div id="page:main-container">
				<div class="columns ">
                
					<div class="" id="page:left">
    											
                        <ul id="isoft" class="tabs">
    					                        
                            
						<li >
                               
                                <div id="isoft_group_4_content1" style="">
								<div class="entry-edit">
                                        <div class="entry-edit-head">
                                            <h4 class="icon-head head-edit-form fieldset-legend">view Exam Schedule</h4>
                                           
                                    	</div>

                                        <div>
        			<div id="customerGrid">
        				
                        
                        <div class="grid">
							<div class="hor-scroll">
							
								<table cellspacing="0" class="data" id="customerGrid_table">
                                <col  width="50"  width="100px"  />
                                <col  width="150"  />
								<col  width="150"  />
                               
                               <thead>
							   
	            	                <tr class="headings">
                                        <th >Subject</th>
                                        <th >Date</th>
										<th >Duration</th>
                                       
	                	            </tr>
								</thead>
	    	    	    		<tbody>
									<%  

								ArrayList arrayList = (ArrayList)request.getAttribute("exmlist");
								if(arrayList!=null){
								for(Iterator iter = arrayList.iterator(); iter.hasNext();) {
						   ExaminationTO ex = (ExaminationTO) iter.next();
						   
						  
						   %>
                                <tr id="" >
                                        <td ><%=ex.getSubject()%></td>
                                        <td class=" "><%=ex.getDate()%></td>
										<td class=" "><%=ex.getDuration()%></td>
                                   </tr>
								   <%}}%>
								</tbody>
								</table>
                            </div>
                        </div>
					</div>
				</div>
									</div>
								
								</div>
                            </li>
						
						</ul>
                        
						<script type="text/javascript">
                            isoftJsTabs = new varienTabs('isoft', 'main_form', 'isoft_group_4', []);
                        </script>
                        
					</div>
                    
					<div class="main-col" id="content">
						<div class="main-col-inner">
							<div id="messages">
                             </div>

                           
                            
                            <form action="#" method="post" id="main_form" name="main_form" enctype="multipart/form-data">
                            	<input type="hidden" id="submitform" name="submitform" value="1" >
                            	<div style="display:none"></div>
                            </form>
						</div>
					</div>
				</div>

                        </div>
        </div>	
			<jsp:include page="footer.jsp"></jsp:include>

</div>

</body>
</html>
