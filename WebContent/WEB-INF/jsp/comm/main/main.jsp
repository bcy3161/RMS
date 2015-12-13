<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/sys/include/doctype.jspf" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">

<!-- Start Head -->
<head>
	<title>신화명 아구찜</title>
	<!-- Include head file -->
	<%@ include file="/WEB-INF/jsp/sys/include/head.jspf" %>
	<script>
	function viewInfo(frm, cust_no){
		var url='/custom/customInfo/popUpInfo.do';
		var title = "Info";
		var status = "width=550, height=500, resizable=no, scrollbars=no";
		
		frm.cust_no.value=cust_no;
		
		window.open("",title,status);
		frm.target = title;
		frm.action = url;
		frm.method = "post";
		frm.submit();
	}
	
	$(document).ready(function() {
	    $('#dataTables-Daily').DataTable( {
	    	"order":[[1,'desc']],
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
	                .column( 6 )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column( 6 ).footer() ).html(
	            	numberWithCommas(total) +' 원'
	            );
	        }
	    } );
	} );
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
                    <h1 class="page-header">신화명 아구찜</h1>
                </div>
            </div>
            <!-- End Subtitle -->
            <!-- Start summary -->
            <div class="row">
            	<!-- 신화명 주문 -->
            	<div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-bar-chart-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${sales_sum_1 }</div>
                                    <div>신화명</div>
                                </div>
                            </div>
                        </div>
                        <!-- 신화명 주문 -->
                        <a href="/order/order/order_sin.do">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            	<!-- 월 매출 요약 -->
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-bar-chart-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${sales_sum_2 }</div>
                                    <div>물꽁</div>
                                </div>
                            </div>
                        </div>
                        <a href="/order/order/order_mul.do">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <!-- 가계부 요약 -->
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-bar-chart-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${sales_sum_3 }</div>
                                    <div>청진동</div>
                                </div>
                            </div>
                        </div>
                        <a href="/order/order/order_chung.do">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <!-- 회원관리 요약 -->
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-wrench fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${cust_cnt }</div>
                                    <div>회원관리</div>
                                </div>
                            </div>
                        </div>
                        <a href="/custom/custom/customer.do">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- End summary -->
            <!-- Start Contents -->
			<div class="row">
                <div class="col-lg-12">
                	<!-- Start Today List -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-shopping-cart fa-fw"></i> 금일 주문
                        </div>
                        <div class="panel-body">
                        	<div class="dataTable_wrapper">
						        <form name="aform" id="aform" method="post">
						        	<input type="hidden" name="cust_no"/>
									<table class="table table-striped table-bordered table-hover" id="dataTables-Daily">
										<thead>
								            <tr>
								            	<th width="5px;"></th>
								                <th>순번</th>
								                <th>주소</th>
								                <th>전화번호</th>
								                <th>메뉴</th>
								                <th>결제 수단</th>
								                <th>매출</th>
								            </tr>
								        </thead>
								        <tfoot>
								            <tr>
								                <th colspan="6" style="text-align:right">Total:</th>
								                <th></th>
								            </tr>
								        </tfoot>
								        <tbody>
								        	<c:forEach items="${today_list }" var="result" varStatus="status">
												
								        		<tr onclick="viewInfo(document.aform,${result.CUST_NO})">
								        			<td id="td${status.count }">
								        			</td>
								        			<c:if test="${result.SECTION =='1'}">
								        				<script>
								        				$("#td${status.count }").css("background-color","#2e6da4");
								        				</script>
								        			</c:if>
								        			<c:if test="${result.SECTION =='2'}">
								        				<script>
								        				$("#td${status.count }").css("background-color","#5cb85c");
								        				</script>
								        			</c:if>
								        			<c:if test="${result.SECTION =='3'}">
								        				<script>
								        				$("#td${status.count }").css("background-color","#f0ad4e");
								        				</script>
								        			</c:if>
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
								        				${result.PAY }
								        			</td>
								        			<td>
								        				${result.COST_SUM }
								        			</td>
								        		</tr>
								        	</c:forEach>
								        </tbody>
								    </table>
								</form>
                            </div>
                        </div>
                    </div>
                    <!-- End Today List -->
                    <!-- Start Daily Sum -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> 일별 통계
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- End Daily Sum -->
                </div>
            </div>
            <!-- End COntents -->
		</div>
		<!-- End Contents -->
	</div>
	<!-- Include foot file -->
	<%@ include file="/WEB-INF/jsp/sys/include/footer.jspf" %>
</body>
<!-- End Body -->
</html>