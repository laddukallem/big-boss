
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
       
       <jsp:include page="admin_header.jsp"></jsp:include>
		
		
		
	
		
        		<div class="middle" id="anchor-content">
            <div id="page:main-container">
				<div class="columns ">
                
					<div class="" id="page:left">
    											
                        <ul id="isoft" class="tabs">
    					                        
                            
						<li >
                               
                                <div id="isoft_group_4_content1" style="">
								<div class="entry-edit">
                                        <div class="entry-edit-head">
                                            <h4 class="icon-head head-edit-form fieldset-legend">Seat Arrangement </h4>
                                            <div class="form-buttons">

                                            </div>
                                    	</div>

                                        <fieldset id="group_fields4">
										
                                            <div class="hor-scroll">
											<form action="SeatingArangementAction" method="post">
                                                <table cellspacing="0" class="form-list">
                                                <tbody>
									
													<tr class="hidden">
                                                      <td class="label"><label >From (Roll no)</label></td>
													  <td class="value">
                                                        	<input id="" name="fromroll" value="" class=" input-text" type="text"/>
                                                        </td>
                                                        <td><small></small></td>
                                                    </tr>
													<tr class="hidden">
                                                      <td class="label"><label >To (Roll no)</label></td>
													  <td class="value">
                                                        	<input id="" name="toroll" value="" class=" input-text" type="text"/>
                                                        </td>
                                                        <td><small></small></td>
                                                    </tr>
													<tr class="hidden">
                                                      <td class="label"><label >Class Room No</label></td>
													  <td class="value">
                                                        	<input id="" name="clsroomno" value="" class=" input-text" type="text"/>
                                                        </td>
                                                        <td><small></small></td>
                                                    </tr>
													
													
													
													
												</table>
												<table style="text-align:center;margin:30px  0 50px 250px;">
												<tr >
                                                     
													  <td >
                                                        	<input id="" name="" value="Submit"  type="submit"/>
                                                        </td>
                                                        
                                                    </tr>
												</table>
												
												</form>
                                            </div>
                                        </fieldset>
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
