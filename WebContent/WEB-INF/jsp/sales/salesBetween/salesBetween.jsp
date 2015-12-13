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
		actSubmit(document.aform, '/sales/salesBetween/salesBetween.do');
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
	                .column( 4 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 4 ).footer() ).html(
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
			dateFormat: 'yy-mm-dd',
			monthNamesShort:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
			dayNamesMin:['일','월','화','수','목','금','토'],
			changeMonth: true,
			changeYear: true,
			showMonthAfterYear: true
		});
	});

	$(function(){
		$('#edate').datepicker({
			dateFormat: 'yy-mm-dd',
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
                    <h1 class="page-header"> 기간별 매출</h1>
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
                            <i class="fa fa-shopping-cart fa-fw"></i> 검색조건
                        </div>
                        <!-- End Panel Head -->
                        <!-- Start Panel Body -->
                        <div class="panel-body">
                        	<!-- Start Form for Submit -->
                        	<form name="aform" id="aform" method="post">
	                        	<!-- Start Row in the Panel -->
								<div class="row">
									<!-- Start left in the Panel -->
									<div class="col-lg-3">
										<div class="form-group">
											<label> 시작날짜</label>
											<input class="form-control" id="sdate" name="sdate" value="${sdate }">
										</div>
										<button type="submit" class="btn btn-outline btn-default" onclick="fnSubmit()"> 검색</button>
									</div>
									<div class="col-lg-3">
										<div class="form-group">
											<label> 끝 날짜</label>
											<input class="form-control" id="edate" name="edate" value="${edate }">
										</div>
									</div>
									<div class="col-lg-3">
										<div class="form-group">
											<label> 결제 구분</label>
											<div class="checkbox">
												<label>
													<input type="checkbox" name="pay" id="pay_all" value="전체" checked="checked">전체
												</label>
											</div>
											<div class="checkbox">
												<label>
													<input type="checkbox" name="pay" id="pay_cash" value="현금">현금
												</label>
											</div>
											<div class="checkbox">
												<label>
													<input type="checkbox" name="pay" id="pay_credit" value="카드">카드
												</label>
											</div>
											<div class="checkbox">
												<label>
													<input type="checkbox" name="pay" id="pay_baedal" value="배달의민족">배민
												</label>
											</div>
										</div>
									</div>
									<div class="col-lg-3">
										<div class="form-group">
											<label> 매출 구분</label>
											<div class="checkbox">
												<label>
													<input type="checkbox" name="section" id="pay_cash" value="현금" >전체
												</label>
											</div>
											<div class="checkbox">
												<label>
													<input type="checkbox" name="section" id="pay_credit" value="카드">신화명
												</label>
											</div>
											<div class="checkbox">
												<label>
													<input type="checkbox" name="section" id="pay_baedal" value="배달의민족">물꽁
												</label>
											</div>
											<div class="checkbox">
												<label>
													<input type="checkbox" name="section" id="pay_baedal" value="배달의민족">청진동
												</label>
											</div>
										</div>
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
							                <th>매출</th>
							            </tr>
							        </thead>
							        <tfoot>
							            <tr>
							                <th colspan="4" style="text-align:right">Total:</th>
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
							        				${result.ADDRESS }
							        			</td>
							        			<td>
							        				${result.PHONE }
							        			</td>
							        			<td>
							        				${result.MENU }
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