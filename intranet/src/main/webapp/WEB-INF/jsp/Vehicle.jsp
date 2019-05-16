<%-- <!DOCTYPE html><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%><%@page
	import="com.ember.vendor.sessioncontroller.UserSession"%><%@ taglib
	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<head>

<script>
	$.widget.bridge('uibutton', $.ui.button);
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#enquiry-table').paging({
			limit : 5
		});
	});
</script>
<script type="text/javascript"
	src="js/custom/stockAudit/stockAuditReports/stockAudStatusUpdate.js"></script>

<style type="text/css">
.paging-nav {
	text-align: center;
	padding-top: 2px;
}

.paging-nav a {
	margin: auto 1px;
	text-decoration: none;
	display: inline-block;
	padding: 1px 7px;
	background: #d5d7d9;
	color: #444;
	border-radius: 3px;
}

.paging-nav .selected-page {
	background: #d5d7d9;
	font-weight: bold;
}

a:hover, a:active, a:focus {
	outline: none;
	text-decoration: none;
	color: #a50032;
}

.error {
	color: red;
}

.success {
	color: green;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="content-wrapper">
		<section class="content-header content-title">
			<h1>Stock Audit Status Update</h1>
			<ol class="breadcrumb">
				<li>Stock Audit</li>
				<li class="active">${menuName}</li>
			</ol>
		</section>

		<section class="content acceptance-content">
			<form:form name="assignmentStatusUpdate" method="POST"
				modelAttribute="assignmentStatusUpdate" class="form-horizontal"
				role="form">
				<c:if test="${not empty successMessage}">
					<div class="text-center well well-sm">
						<span class=success>${successMessage}</span>
					</div>
				</c:if>

				<c:if test="${not empty errorMessage}">
					<div class="text-center well well-sm">
						<span class="error">${errorMessage}</span>
					</div>
				</c:if>
				<div class="box box-default" id="enqcriteria">
					<div class="box-header with-border">
						<h3 class="box-title">Enquiry Criteria</h3>
						<div class="box-tools pull-right">
							<button class="btn btn-box-tool" data-widget="collapse">
								<i class="fa fa-minus" id="btnenqcrit"></i>
							</button>
						</div>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div class="row">
							<div class="col-lg-6">
								<label class="text-up" for="sel1">Request No</label>
								<div class="inner-addon right-addon">
									<input id="requestNo" type="search" placeholder="Request No"
										name="requestNo" maxlength="20" class="form-control" />
								</div>
							</div>
							<div class="col-lg-6">
								<label class="text-up" for="sel1">CIFID</label>
								<div class="inner-addon right-addon">
									<input id="customerId" type="search" placeholder="CIFID"
										name="customerId" maxlength="20" class="form-control" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-6">
								<label class="text-up" for="sel1">Borrower Name</label>
								<div class="inner-addon right-addon">
									<input id="borrowerName" type="search"
										placeholder="Borrower Name" maxlength="20"
										class="form-control" />
								</div>
							</div>
							<c:if test="${userType ne 'VND'}">
								<div class="col-lg-6  vendor-text">
									<label class="text-up" for="sel1">Vendor Name</label>
									<div class="inner-addon right-addon">
										<i class="fa fa-search glyphicon"></i> <input type="search"
											id="vendorName" placeholder="Vendor Name" name="vendorName"
											maxlength="20" class="form-control" onclick="listVendors();" />
										<input type="hidden" name="vendorId" id="vendorId" value="" />
									</div>
								</div>
							</c:if>
						</div>

						<br>
						<div class="row" style="padding-left: 10px">
							<div class="button-listing ">
								<div class="col-sm-2 col-xs-2">
									<button type="button" class="btn btn-primary btn-block"
										id="showbtn" onclick="return showAssignmentsList(this.form);">Show</button>
								</div>
								<div class="col-sm-2 col-xs-2">
									<form:button type="button" class="btn btn-primary btn-block"
										onclick="clearfields();">Clear</form:button>
								</div>

								<div class="col-sm-2 col-xs-2">
									<form:button type="button" class="btn btn-primary btn-block"
										onclick="closeform();">Close</form:button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="box box-default" id="enqdetail">
					<div class="box-header with-border">
						<h3 class="box-title">Enquiry Detail</h3>

						<div class="box-tools pull-right">
							<button class="btn btn-box-tool" data-widget="collapse">
								<i class="fa fa-minus" id="btnenqdtail"></i>
							</button>
						</div>
					</div>
					<!-- /.box-header -->
					<c:if test="${not empty datatoDisplay}">
						<div class="box-body" id="showgrid">
							<div class="box">
								<div id="table_wrapper"
									class="dataTables_wrapper form-inline dt-bootstrap">
									<div class="table-responsive">
										<table class="table table-bordered table-hover dataTable"
											id="enquiry-table" role="grid"
											aria-describedby="example2_info">
											<thead>
												<tr role="row">
													<th class="sorting_asc" tabindex="0"
														aria-controls="data-fl" rowspan="1" colspan="1"
														aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending">Sr.
														No</th>
													<th class="sorting_asc" tabindex="0"
														aria-controls="data-fl" rowspan="1" colspan="1"
														aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending">Request
														No</th>
													<th class="sorting" tabindex="0" aria-controls="data-fl"
														rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending">Borrower
														Name</th>
													<c:if test="${userType eq 'VND'}">
														<th class="sorting" tabindex="0" aria-controls="data-fl"
															rowspan="1" colspan="1"
															aria-label="Engine version: activate to sort column ascending">Status
														</th>
													</c:if>
													<c:if test="${userType ne 'VND'}">
														<th class="sorting" tabindex="0" aria-controls="data-fl"
															rowspan="1" colspan="1"
															aria-label="Engine version: activate to sort column ascending">Vendor
															Name</th>
														<th class="sorting" tabindex="0" aria-controls="data-fl"
															rowspan="1" colspan="1"
															aria-label="Engine version: activate to sort column ascending">Assignment
															Status Vendor</th>
														<th class="sorting" tabindex="0" aria-controls="data-fl"
															rowspan="1" colspan="1"
															aria-label="CSS grade: activate to sort column ascending">Fortnight
															Status</th>
													</c:if>
													<c:if test="${userType ne 'VND' && userType eq 'UNIT' }">
														<th class="sorting" tabindex="0" aria-controls="data-fl"
															rowspan="1" colspan="1"
															aria-label="CSS grade: activate to sort column ascending">CBB/
															CCMC Head Response</th>
													</c:if>
													<c:if test="${userType ne 'VND' && userType eq 'CCCHF' }">
														<th class="sorting" tabindex="0" aria-controls="data-fl"
															rowspan="1" colspan="1"
															aria-label="CSS grade: activate to sort column ascending">CBB/
															CCMC Head Response</th>
														<th class="sorting" tabindex="0" aria-controls="data-fl"
															rowspan="1" colspan="1"
															aria-label="CSS grade: activate to sort column ascending">Final
															Action</th>
													</c:if>
												</tr>
											</thead>
											<tbody>
												<c:if test="${empty datatoDisplay}">
													<tr role="row" class="odd">
														<td colspan="8">No Data to display</td>
													</tr>
												</c:if>
												<c:if test="${userType eq 'VND'}">
													<c:forEach items="${assgStatusUpdateList}" var="item">
														<tr role="row" class="odd" style="cursor: pointer;">
															<td style="max-width: 30px;"><input type="checkbox"
																class="sorting_1 text-nowrap assignmentStatusSrNo"
																id="${item.assignmentId}" value="${item.assignmentId}" /></td>
															<td class="sorting_1 text-nowrap">${item.requestNo}<input
																type="hidden" id="${item.assignmentId}requestNo"
																value="${item.requestNo}"></td>
															<td class="sorting_1 text-nowrap">${item.borrowerName}<input
																type="hidden" id="${item.assignmentId}borrowerName"
																value="${item.borrowerName}"></td>
															<td><div>
																	<select class="form-control text-nowrap"
																		style="width: 600px;" id="${item.assignmentId}status">
																		<option value="0">--Select --</option>
																		<c:forEach items="${statusList}" var="item">
																			<option value="${item.reasonMasterId}">${item.reason}</option>
																		</c:forEach>
																	</select>
																</div></td>
														</tr>
													</c:forEach>
												</c:if>
												<c:if test="${userType eq 'CCCH'}">
													<c:forEach items="${assgStatusUpdateList}" var="item">
														<tr role="row" class="odd" style="cursor: pointer;">
															<td style="max-width: 30px;"><input type="checkbox"
																class="sorting_1 text-nowrap assignmentStatusSrNo"
																id="${item.assignmentId}" value="${item.assignmentId}" />
															<td class="sorting_1 text-nowrap">${item.requestNo}<input
																type="hidden" id="${item.assignmentId}requestNo"
																value="${item.requestNo}"></td>
															<td class="sorting_1 text-nowrap">${item.borrowerName}<input
																type="hidden" id="${item.assignmentId}borrowerName"
																value="${item.borrowerName}"></td>
															<td class="sorting_1 text-nowrap">${item.vendorName}<input
																type="hidden" id="${item.assignmentId}vendorName"
																value="${item.vendorName}"></td>
															<td class="sorting_1 text-nowrap">${item.statusByVendor}<input
																type="hidden" id="${item.assignmentId}statusByVendor"
																value="${item.statusByVendor}"></td>
															<td class="sorting_1 text-nowrap"><select
																id="${item.assignmentId}status" class="form-control"
																style="width: 600px;">
																	<option value="0">--Select --</option>
																	<c:forEach items="${statusList}" var="item">
																		<option value="${item.reasonMasterId}">${item.reason}</option>
																	</c:forEach>
															</select></td>
														</tr>
													</c:forEach>
												</c:if>
												<c:if test="${userType eq 'UNIT'}">
													<c:forEach items="${assgStatusUpdateList}" var="item">
														<tr role="row" class="odd" style="cursor: pointer;">
															<td style="max-width: 30px;"><input type="checkbox"
																class="sorting_1 text-nowrap assignmentStatusSrNo"
																id="${item.assignmentId}" value="${item.assignmentId}" />
															<td class="sorting_1 text-nowrap">${item.requestNo}<input
																type="hidden" id="${item.assignmentId}requestNo"
																value="${item.requestNo}"></td>
															<td class="sorting_1 text-nowrap">${item.borrowerName}<input
																type="hidden" id="${item.assignmentId}borrowerName"
																value="${item.borrowerName}"></td>
															<td class="sorting_1 text-nowrap">${item.vendorName}<input
																type="hidden" id="${item.assignmentId}vendorName"
																value="${item.vendorName}"></td>
															<td class="sorting_1 text-nowrap">${item.statusByVendor}<input
																type="hidden" id="${item.assignmentId}statusByVendor"
																value="${item.statusByVendor}"></td>
															<td class="sorting_1 text-nowrap">${item.statusByCCCH}<input
																type="hidden" id="${item.assignmentId}statusByCCCH"
																value="${item.statusByCCCH}"></td>
															<td class="sorting_1 text-nowrap"><select
																id="${item.assignmentId}status" class="form-control"
																style="width: 450px;">
																	<option value="0">--Select --</option>
																	<c:forEach items="${statusList}" var="item">
																		<option value="${item.reasonMasterId}">${item.reason}</option>
																	</c:forEach>
															</select></td>
														</tr>
													</c:forEach>
												</c:if>
												<c:if test="${userType eq 'CCCHF'}">
													<c:forEach items="${assgStatusUpdateList}" var="item">
														<tr role="row" class="odd" style="cursor: pointer;">
															<td style="max-width: 30px;"><input type="checkbox"
																class="sorting_1 text-nowrap assignmentStatusSrNo"
																id="${item.assignmentId}" value="${item.assignmentId}" />
															<td class="sorting_1 text-nowrap">${item.requestNo}<input
																type="hidden" id="${item.assignmentId}requestNo"
																value="${item.requestNo}"></td>
															<td class="sorting_1 text-nowrap">${item.borrowerName}<input
																type="hidden" id="${item.assignmentId}borrowerName"
																value="${item.borrowerName}"></td>
															<td class="sorting_1 text-nowrap">${item.vendorName}<input
																type="hidden" id="${item.assignmentId}vendorName"
																value="${item.vendorName}"></td>
															<td class="sorting_1 text-nowrap">${item.statusByVendor}<input
																type="hidden" id="${item.assignmentId}statusByVendor"
																value="${item.statusByVendor}"></td>
															<td class="sorting_1 text-nowrap">${item.statusByCCCH}<input
																type="hidden" id="${item.assignmentId}statusByCCCH"
																value="${item.statusByCCCH}"></td>
															<td class="sorting_1 text-nowrap">${item.statusByUnit}<input
																type="hidden" id="${item.assignmentId}statusByUnit"
																value="${item.statusByUnit}"></td>
															<td class="sorting_1 text-nowrap"><select
																id="${item.assignmentId}status" class="form-control"
																style="width: 450px;">
																	<option value="0">--Select --</option>
																	<c:forEach items="${statusList}" var="item">
																		<option value="${item.reasonMasterId}">${item.reason}</option>
																	</c:forEach>
															</select></td>
														</tr>
													</c:forEach>
												</c:if>

											</tbody>
										</table>
									</div>
								</div>
								<br>
								<div class="row" style="padding-left: 10px">
									<div class="button-listing ">
										<div class="col-sm-2 col-xs-2">
											<button type="button" class="btn btn-primary btn-block"
												id="showbtn"
												onclick="return updateAssignmentsStatusList(this.form);">Update</button>
										</div>
										<div class="col-sm-2 col-xs-2">
											<form:button type="button" class="btn btn-primary btn-block"
												onclick="clearfields();">Clear</form:button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</div>
				<input type="hidden" id="userType" value="${userType}">
				<input type="hidden" id="selectedAssgmId" name="selectedAssgmId"
					value="">
				<input type="hidden" id="selectedAssgmStatusId"
					name="selectedAssgmStatusId" value="">
				<input type="hidden" id="selectedAssgmRemark"
					name="selectedAssgmRemark" value="">
			</form:form>
		</section>
	</div>
	<script type="text/javascript">
		$(".toggleBtn").on(
				'click',
				function() {
					$(this).children('.fa-minus, .fa-plus').toggleClass(
							"fa-minus fa-plus");
				});
		var picker = new Pikaday({
			field : document.getElementById('datepicker'),
			firstDay : 1,
			minDate : new Date(2000, 0, 1),
			maxDate : new Date(2020, 12, 31),
			yearRange : [ 2000, 2020 ]
		});
		var picker = new Pikaday({
			field : document.getElementById('datepicker'),
			firstDay : 1,
			minDate : new Date(2000, 0, 1),
			maxDate : new Date(2099, 12, 31),
			yearRange : [ 2000, 2099 ]
		});
		var picker = new Pikaday({
			field : document.getElementById('datepicker1'),
			firstDay : 1,
			minDate : new Date(2000, 0, 1),
			maxDate : new Date(2099, 12, 31),
			yearRange : [ 2000, 2099 ]
		});
		$('.custom-upload input[type=file]').change(function() {
			$(this).next().find('input').val($(this).val());
		});

		function validateForm() {
			var form = document.getElementById("stockauditfetch");
			var txtReportDate = document.getElementById('datepicker').value;
			if (txtReportDate == "") {
				alert('Please select report date.');
				return false;
			}

			return true;
		}
	</script>
</body>
</html> --%>