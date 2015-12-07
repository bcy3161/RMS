<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/sys/include/doctype.jspf" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">

<!-- Start Head -->
<head>
	<title>신화명 아구찜</title>
	<!-- Include head file -->
	<%@ include file="/WEB-INF/jsp/sys/include/head.jspf" %>
	<script>
		function insertFlavor(name_no){
			if(name_no == 10000){
				document.getElementById("flavor").innerHTML=
					"";
			}
			else if(name_no>9000){
				document.getElementById("flavor").innerHTML=
					"<label> 수량&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"+
					"<input type='text' class='form-control'>";
			}
			else{
				document.getElementById("flavor").innerHTML=
					"<label> 맛&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"+
					"<label class='radio-inline'>"+
					"<input type='radio' name='optionsRadiosInline' id='optionsRadiosInline1' value='option1' checked>맵게</label>"+
					"<label class='radio-inline'>"+
					"<input type='radio' name='optionsRadiosInline' id='optionsRadiosInline1' value='option2'>보통</label>"+
					"<label class='radio-inline'>"+
					"<input type='radio' name='optionsRadiosInline' id='optionsRadiosInline1' value='option3'>순하게</label>";
			}
		}
	
		function getSelectValue(){
			var select = document.getElementById("menu");
			var name_no = select.options[select.selectedIndex].value;
			
			insertFlavor(name_no);
		}
	
		
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
                    <h1 class="page-header"> 주문</h1>
                </div>
            </div>
            <!-- End Subtitle -->
            <!-- Start Row -->
            <div class="row">
            	<!-- Start Col -->
            	<div class="col-lg-4">
            		<!-- Start Input -->
                    <div class="panel panel-default">
                    	<!-- Start Panel Head -->
                        <div class="panel-heading">
                            <i class="fa fa-shopping-cart fa-fw"></i> Input
                        </div>
                        <!-- End Panel Head -->
                        <!-- Start Panel Body -->
                        <div class="panel-body">
                        	<!-- Start Row in the Panel -->
							<div class="row">
								<!-- Start left in the Panel -->
								<div class="col-lg-12">
									<div class="form-group input-group">
										<label> 전화 번호</label>
										<input type="text" class="form-control">
										<span class="input-group-btn">
											<button class="btn btn-outline btn-default" type="button" style="margin-top: 25px; height: 34px;"><i class="fa fa-search"></i>
											</button>
										</span>
									</div>
									<div class="form-group">
										<label> 주소</label>
										<input class="form-control">
									</div>
									<div class="form-group">
										<label> 주문</label>
										<select name="menu" id="menu" class="form-control" onchange="getSelectValue();">
											<option value="010000">메뉴를 선택하세요</option>
											<c:forEach items="${menuList }" var="result" varStatus="status">
												<option value="${result.MENU_NO }">${result.MENU_NAME }&nbsp;&nbsp;${result.MENU_SIZE }</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<div  id="flavor"></div>
										<button class="btn btn-outline btn-primary pull-right"> 추가</button>
									</div>	
									
									<div class="form-group">
										<label> 주문 내역</label>
										<select multiple class="form-control">
											<option>test</option>
										</select>
                                    </div>
                                    <div class="form-group">
										<label> 가격</label>
										<input class="form-control" id="disabledInput" type="text" placeholder="원" disabled>
									</div>
									<button type="submit" class="btn btn-outline btn-default"> 주문</button>
									<button type="reset" class="btn btn-outline btn-default"> 초기화</button>
								</div>
								<!-- End left in the Panel -->
							</div>
	                        <!-- End Row in the Panel -->
                        </div>
                        <!-- End Panel Body -->
                    </div>
                    <!-- End Input -->
				</div>
				<div class="col-lg-8">
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
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>NO</th>
                                                    <th>주소</th>
                                                    <th>전화번호</th>
                                                    <th>주문내역</th>
                                                    <th>가격</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>3326</td>
                                                    <td>화명동 대우이안아파트 107동 2403호</td>
                                                    <td>01066854025</td>
                                                    <td>아구찜 대 맵게<br>우동사리</td>
                                                    <td>38,000</td>
                                                </tr>
                                                <tr>
                                                    <td>3326</td>
                                                    <td>화명동 대우이안아파트 107동 2403호</td>
                                                    <td>01066854025</td>
                                                    <td>아구찜 대 맵게<br>우동사리</td>
                                                    <td>38,000</td>
                                                </tr>
                                                <tr>
                                                    <td>3326</td>
                                                    <td>화명동 대우이안아파트 107동 2403호</td>
                                                    <td>01066854025</td>
                                                    <td>아구찜 대 맵게<br>우동사리</td>
                                                    <td>38,000</td>
                                                </tr>
                                                <tr>
                                                    <td>3326</td>
                                                    <td>화명동 대우이안아파트 107동 2403호</td>
                                                    <td>01066854025</td>
                                                    <td>아구찜 대 맵게<br>우동사리</td>
                                                    <td>38,000</td>
                                                </tr>
                                                <tr>
                                                    <td>3326</td>
                                                    <td>화명동 대우이안아파트 107동 2403호</td>
                                                    <td>01066854025</td>
                                                    <td>아구찜 대 맵게<br>우동사리</td>
                                                    <td>38,000</td>
                                                </tr>
                                                <tr>
                                                    <td>3326</td>
                                                    <td>화명동 대우이안아파트 107동 2403호</td>
                                                    <td>01066854025</td>
                                                    <td>아구찜 대 맵게<br>우동사리</td>
                                                    <td>38,000</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.col-lg-4 (nested) -->
                                <div class="col-lg-8">
                                    <div id="morris-bar-chart"></div>
                                </div>
                                <!-- /.col-lg-8 (nested) -->
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