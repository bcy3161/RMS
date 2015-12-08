<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/sys/include/doctype.jspf" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">

<!-- Start Head -->
<head>
	<title>신화명 아구찜</title>
	<!-- Include head file -->
	<%@ include file="/WEB-INF/jsp/sys/include/head.jspf" %>
	<script>
		function actSubmit(frm, url)
		{
			frm.method = 'post';
			frm.action = url;
		}
		function fnSearch() {
			actSubmit(document.aform, '/custom/custom/addCustomer.do');
			alert("추가완료");
		}
		
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
                    <h4 class="page-header"> 고객추가</h1>
                </div>
            </div>
            <!-- End Subtitle -->
            <!-- Start Row -->
            <div class="row">
                <div class="col-lg-12">
                	<!-- Start aForm for Submit -->
                    <form name="aform" id="aform" method="post">
						<div class="form-group input-group">
							<label> 전화 번호</label>
							<input type="text" id="phone" name="phone" value="${phone }" class="form-control">
							<span class="input-group-btn">
								<button class="btn btn-outline btn-default" type="submit" onclick="fnSearch()" style="margin-top: 25px; height: 34px;"><i class="fa fa-search"></i>
								</button>
							</span>
						</div>
						<div class="form-group">
							<label> 주소</label>
							<input type="text" id="address" name="address" value="${address }" class="form-control">
						</div>
						
						<button type="submit" class="btn btn-outline btn-default" onclick="fnSearch()"> 추가</button>
						<button type="submit" class="btn btn-outline btn-default" onclick="fnClose()"> 닫기</button>
					</form>
					<!-- End aForm for Submit -->
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