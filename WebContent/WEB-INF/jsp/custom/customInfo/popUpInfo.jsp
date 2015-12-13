<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/sys/include/doctype.jspf" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">

<!-- Start Head -->
<head>
	<title>신화명 아구찜</title>
	<!-- Include head file -->
	<%@ include file="/WEB-INF/jsp/sys/include/head.jspf" %>
	<script>
		function fnClose(){
			window.close();
		}
    </script>
</head>
<!-- End Head -->
<!-- Start Body -->
<body >

	<div id="wrapper">
		<!-- Include Navi file -->
		<%@ include file="/WEB-INF/jsp/sys/include/navi.jspf" %>
		
		<!-- Start Contents -->
		<div id="page-wrapper">
			<!-- Start Subtitle -->
			<div class="row">
                <div class="col-lg-12">
                    <h4 class="page-header"> 고객상세정보</h1>
                </div>
            </div>
            <!-- End Subtitle -->
            <!-- Start Row -->
            <div class="row">
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
                           <div class="row">
                                <div class="col-lg-12">
                                    <div class="dataTable_wrapper">
										<table class="table table-striped table-bordered table-hover" id="dataTables-Daily">
											<thead>
									            <tr>
									                <th>순번</th>
									                <th>메뉴</th>
									                <th>구분</th>
									            </tr>
									        </thead>
									        <tfoot>
									        	<tr>
									                <th colspan="2" style="text-align:right">Count:</th>
									                <th>${cnt }</th>
									            </tr>
									        </tfoot>
									        <tbody>
									        	<c:forEach items="${sales_List }" var="result" varStatus="status">
									        		<tr>
									        			<td>
									        				${status.count }
									        			</td>
									        			<td>
									        				${result.MENU }
									        			</td>
									        			<td>
									        				${result.SECTION }
									        			</td>
									        		</tr>
									        	</c:forEach>
									        </tbody>
									    </table>
		                            </div>
                                </div>
                                <div class="col-lg-8">
                                    <div id="morris-bar-chart"></div>
                                </div>
                            </div>
                        </div>
                        <!-- End Panel Body -->
                    </div>
                    <!-- End output -->
					<button type="submit" class="btn btn-outline btn-default" onclick="fnClose()"> 닫기</button>
                </div>
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