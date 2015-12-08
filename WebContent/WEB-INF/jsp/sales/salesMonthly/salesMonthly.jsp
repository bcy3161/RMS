<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/sys/include/doctype.jspf" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">

<!-- Start Head -->
<head>
	<title>신화명 아구찜</title>
	<!-- Include head file -->
	<%@ include file="/WEB-INF/jsp/sys/include/head.jspf" %>
	
	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
	
	function actSubmit(frm, url)
	{
		frm.method = 'post';
		frm.action = url;
	}
	function fnSubmit() {
		actSubmit(document.aform, '/sales/salesMonthly/salesMonthly.do');
	}
	
	$(document).ready(function() {
	    $('#dataTables-Daily').DataTable( {
	    	"paging":   false,
	        "footerCallback": function ( row, data, start, end, display ) {
	            var api = this.api(), data;
	 
	            // Remove the formatting to get integer data for summation
	            var intVal = function ( i ) {
	                return typeof i === 'string' ?
	                    i.replace(/[\$,]/g, '')*1 :
	                    typeof i === 'number' ?
	                        i : 0;
	            };
	 
	            // Total over all pages
	            total = api
	                .column( 5 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 5 ).footer() ).html(
	                total +' 원'
	            );
	        }
	    } );
	} );
	
	/**
	* For Date Picker
	*/
	$(function(){
		$('#sdate').datepicker({
			dateFormat: 'yy-mm',
			monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			dayNamesMin:['일','월','화','수','목','금','토'],
			changeMonth: true,
			changeYear: true,
			showMonthAfterYear: true
		});
	});
	
	</script>
</head>
<!-- End Head -->
<!-- Start Body -->
<body>

	<div id="wrapper">
		<!-- Include Navi file -->
		<%@ include file="/WEB-INF/jsp/sys/include/navi.jspf" %>
		
		<!-- Start Contents -->
		<div id="page-wrapper">
			<!-- Start Subtitle -->
			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"> 월 매출</h1>
                </div>
            </div>
            <!-- End Subtitle -->
            <!-- Start Row -->
            <div class="row">
            	<!-- Start Col -->
            	<div class="col-lg-12">
            		<!-- Start Input -->
                    <div class="panel panel-default">
                    	<!-- Start Panel Head -->
                        <div class="panel-heading">
                            <i class="fa fa-shopping-cart fa-fw"></i> Input
                        </div>
                        <!-- End Panel Head -->
                        <!-- Start Panel Body -->
                        <div class="panel-body">
                        	<!-- Start Form for Submit -->
                        	<form name="aform" id="aform" method="post">
	                        	<!-- Start Row in the Panel -->
								<div class="row">
									<!-- Start left in the Panel -->
									<div class="col-lg-12">
										<div class="form-group">
											<label> 날짜</label>
											<input class="form-control" id="sdate" name="sdate" value="${sdate }">
										</div>
										<button type="submit" class="btn btn-outline btn-default" onclick="fnSubmit()"> 검색</button>
										<button type="reset" class="btn btn-outline btn-default"> 초기화</button>
									</div>
									<!-- End left in the Panel -->
								</div>
		                        <!-- End Row in the Panel -->
		                    </form>
		                    <!-- End Form -->
                        </div>
                        <!-- End Panel Body -->
                    </div>
                    <!-- End Input -->
				</div>
				<div class="col-lg-12">
                    <!-- Start Output -->
                    <div class="panel panel-default">
                    	<!-- Start Panel Head -->
                        <div class="panel-heading">
                            <i class="fa fa-shopping-cart fa-fw"></i> Output
                        </div>
                        <!-- End Panel Head -->
                        <!-- Start Panel Body -->
                        <div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover" id="dataTables-Daily">
									<thead>
							            <tr>
							                <th>순번</th>
							                <th>주소</th>
							                <th>전화번호</th>
							                <th>메뉴</th>
							                <th>날짜</th>
							                <th>매출</th>
							            </tr>
							        </thead>
							        <tfoot>
							            <tr>
							                <th colspan="5" style="text-align:right">Total:</th>
							                <th></th>
							            </tr>
							        </tfoot>
							        <tbody>
							        	<c:forEach items="${salesList }" var="result" varStatus="status">
							        		<tr>
							        			<td>
							        				${result.SALES_NO }
							        			</td>
							        			<td>
							        				${result.CUST_NO }
							        			</td>
							        			<td>
							        				${result.CUST_NO }
							        			</td>
							        			<td>
							        				${result.MENU }
							        			</td>
							        			<td>
							        				${result.SALES_DATE }
							        			</td>
							        			<td>
							        				${result.COST_SUM }
							        			</td>
							        		</tr>
							        	</c:forEach>
							        </tbody>
							    </table>
                            </div>
                        </div>
                        <!-- End Panel Body -->
                    </div>
                    <!-- End output -->
                </div>
                <!-- End Col -->
            </div>
            <!-- End Row -->
		</div>
		<!-- End Contents -->
	</div>
	<!-- Include foot file -->
	<%@ include file="/WEB-INF/jsp/sys/include/footer.jspf" %>
</body>
<!-- End Body -->
</html>