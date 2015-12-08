<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/sys/include/doctype.jspf" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">

<!-- Start Head -->
<head>
	<title>신화명 아구찜</title>
	<!-- Include head file -->
	<%@ include file="/WEB-INF/jsp/sys/include/head.jspf" %>
	<script>
	
		function isNumber(s) {
		  s += ''; // 문자열로 변환
		  s = s.replace(/^\s*|\s*$/g, ''); // 좌우 공백 제거
		  if (s == '' || isNaN(s)) return false;
		  return true;
		}
	
		function actSubmit(frm, url)
		{
			frm.method = 'post';
			frm.action = url;
		}
		function fnSearch() {
			actSubmit(document.aform, '/order/order/order.do');
		}
		function fnAddOrder() {
			actSubmit(document.cform, '/order/order/addOrder.do');
		}
	
		var menu_no;
		var cost_sum=parseInt(0);
		/**
		* 주문 시 수량 또는 맛 변경 
		*/
		function insertFlavor(name_no){
			if(name_no == 10000){
				document.getElementById("flavor").innerHTML=
					"";
			}
			else if(name_no>9000){
				document.getElementById("flavor").innerHTML=
					"<label> 수량&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"+
					"<input type='text' name='count' id='count' class='form-control'>";
			}
			else{
				document.getElementById("flavor").innerHTML=
					"<label> 맛&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"+
					"<label class='radio-inline'>"+
					"<input type='radio' name='flavorOption' id='flavorOption1' value='  맵게'>맵게</label>"+
					"<label class='radio-inline'>"+
					"<input type='radio' name='flavorOption' id='flavorOption1' value='  보통' checked>보통</label>"+
					"<label class='radio-inline'>"+
					"<input type='radio' name='flavorOption' id='flavorOption1' value='  순하게'>순하게</label>";
			}
		}
	
		function getSelectValue(){
			var select = document.getElementById("menu");
			menu_no = select.options[select.selectedIndex].value;
			
			insertFlavor(menu_no);
		}
	
		function addCustomer(frm){
			var flag = document.getElementById("cust_no");
			var phone = document.getElementById("phone");
			if(flag.value=='' && phone.value!=''){
				var url='/custom/custom/addCustomerView.do';
				var title = "addNew";
				var status = "width=370, height=360, resizable=no, scrollbars=no";
				
				window.open("",title,status);
				frm.target = title;
				frm.action = url;
				frm.method = "post";
				frm.submit();
			}
		}
		
		function fnAddMenu(){
			var select = document.getElementById("menu");
			var selectedNo = select.options[select.selectedIndex].value;
			var menu_name = select.options[select.selectedIndex].text;
			var menu_cost = document.getElementById(selectedNo).value;
			var flavor;
			var cnt=1;
			if(selectedNo>9000){
				cnt = document.getElementById("count").value;
				flavor = cnt;
				
			}
			else{
				var radio = document.getElementsByName("flavorOption");
				
				for(var i =0 ; i < radio.length ; i++ ){
					if(radio[i].checked == true)
						flavor = radio[i].value;					
				}	
			}
			
			
			insertSelect(this.menu_list,menu_name+"-"+flavor,menu_cost);
			
			//Sum Cost
			cost_sum+=(parseInt(menu_cost)*parseInt(cnt));
			document.getElementById("cost_sum").value=cost_sum;
		}
		
		function fnRemoveMenu(){


			var select = document.getElementById("menu_list");
			var menu_cost = select.options[select.selectedIndex].value;
			var menu_text = select.options[select.selectedIndex].text;
			var cnt_array = menu_text.split("-");
			var cnt = 1;
			if(isNumber(cnt_array[1]))
				cnt = cnt_array[1];
			
			removeSelect(this.menu_list);
			
			//Sum Cost
			cost_sum-=(parseInt(menu_cost)*parseInt(cnt));
			document.getElementById("cost_sum").value=cost_sum;
		}
		
		function insertSelect(theSel, newText, newValue)
		{
			if (theSel.length == 0) {
				var newOpt1 = new Option(newText, newValue);
				theSel.options[0] = newOpt1;
		    	theSel.selectedIndex = 0;
		  	} else if (theSel.selectedIndex != -1) {
		    	var selText = new Array();
		    	var selValues = new Array();
		    	var selIsSel = new Array();
		    	var newCount = -1;
		    	var newSelected = -1;
		    	var i;
		    	for(i=0; i<theSel.length; i++){
		      		newCount++;
		      		if (newCount == theSel.selectedIndex) {
		        		selText[newCount] = newText;
		        		selValues[newCount] = newValue;
		        		selIsSel[newCount] = false;
		        		newCount++;
		        		newSelected = newCount;
		      		}
		      		selText[newCount] = theSel.options[i].text;
		      		selValues[newCount] = theSel.options[i].value;
		      		selIsSel[newCount] = theSel.options[i].selected;
		    	}
		    	for(i=0; i<=newCount; i++){
		      		var newOpt = new Option(selText[i], selValues[i]);
		      		theSel.options[i] = newOpt;
		      		theSel.options[i].selected = selIsSel[i];
		    	}
		  	}
		}
		
		function removeSelect(theSel)
		{
		  	var selIndex = theSel.selectedIndex;
		  	if (selIndex != -1) {
		    	for(i=theSel.length-1; i>=0; i--){
		      		if(theSel.options[i].selected){
		        		theSel.options[i] = null;
		      		}
		    	}
		    	if (theSel.length > 0) {
		      		theSel.selectedIndex = selIndex == 0 ? 0 : selIndex - 1;
		    	}
		  	}
		}

		$(document).ready(function() {
		    $('#dataTables-Daily').DataTable( {
		    	"order":[[0,'desc']],
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
			                       	<!-- Start aForm for Submit -->
			                       	<form name="aform" id="aform" method="post">
										<div class="form-group input-group">
											<label> 전화 번호</label>
											<input type="text" id="phone" name="phone" value="${phone }" class="form-control">
											<span class="input-group-btn">
												<button class="btn btn-outline btn-default" onclick="fnSearch()" style="margin-top: 25px; height: 34px;"><i class="fa fa-search"></i>
												</button>
											</span>
										</div>
										<div class="form-group">
											<label> 주소</label>
											<input type="text" id="address" name="address" value="${address }" class="form-control">
										</div>
										<input type="hidden" id="cust_no" name="cust_no" value="${cust_no }"/>
									</form>
									<!-- End aForm for Submit -->
									
									<!-- Start bForm for Popup Submit-->
			                       	<form name="bform" id="bform" method="post">
										<input type="hidden" id="cust_no" name="cust_no" value="${cust_no }"/>
										<input type="hidden" id="phone" name="phone" value="${phone }"/>
									</form>
									<!-- End bForm for Popup Submit-->
									
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
										<!--  -->
										<c:forEach items="${menuList }" var="result" varStatus="status">
											<input type="hidden" id="${result.MENU_NO }" value="${result.MENU_COST }"/>
										</c:forEach>
										<div id="flavor"></div>
										&nbsp;
										<button class="btn btn-outline btn-primary pull-right btn-sm" style="margin-left: 5px;" onclick="fnRemoveMenu()"> 제거</button>
										&nbsp;
										<button class="btn btn-outline btn-primary pull-right btn-sm" onclick="fnAddMenu()"> 추가</button>
									</div>	
									
			                       	<form name="cform" id="cform" method="post">
										<input type="hidden" id="cust_no" name="cust_no" value="${cust_no }"/>
										<input type="hidden" id="phone" name="phone" value="${phone }"/>
										<input type="hidden" id="address" name="address" value="${address }"/>
										<input type="hidden" id="menu" name="menu" value="test"/>
										<div class="form-group">
											<label> 주문 내역</label>
											<select multiple="multiple" class="form-control" id="menu_list" name="menu_list">
											</select>
	                                    </div>
	                                    <div class="form-group">
											<label> 가격</label>
											<input class="form-control" id="cost_sum" name="cost_sum" type="text" readonly="readonly">
										</div>
										<button type="submit" class="btn btn-outline btn-default" onclick="fnAddOrder()"> 주문</button>
										<button type="reset" class="btn btn-outline btn-default"> 초기화</button>
									</form>
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
									        	<c:forEach items="${today_list }" var="result" varStatus="status">
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
									        				${result.COST_SUM }
									        			</td>
									        		</tr>
									        	</c:forEach>
									        </tbody>
									    </table>
		                            </div>
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
	<script>
		addCustomer(document.bform);
	</script>
	<%@ include file="/WEB-INF/jsp/sys/include/footer.jspf" %>
</body>
<!-- End Body -->
</html>