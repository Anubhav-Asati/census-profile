<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="css/add-emp.css" rel="stylesheet">
</head>
<body>

<div class="container">
			<div class="main">
				<div class="main-center">
				<h4 align="center">FamilyHead Edit Form</h4>
					<form class="" method="post" action="post-edithead">
						<div class="form-group">
							<label for="familyHeadId">Family HeadId</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="familyHeadId" id="familyHeadId"  value="${familyHead.familyHeadId}" readonly="readonly" />
							</div>


</div>
<div class="form-group">
<label for="firstName">Edit FamilyHead First Name</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="firstName" id="firstName" value="${familyHead.firstName}" />
</div>
<div class="form-group">
<label for="lastName">Edit FamilyHead Last Name</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="lastName" id="lastName" value="${familyHead.lastName}" />
</div>

</div>

<div class="form-group">
<label for="gender">Edit Gender</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="gender" id="gender" value="${familyHead.gender}" />
</div>
</div>

<div class="form-group">
<label for="suffix">Edit Suffix</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="suffix" id="suffix" value="${familyHead.suffix}" />
</div>
</div>


<div class="form-group">
<label for="birthdate">Edit Birthdate</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="date" class="form-control" name="birthdate" id="birthdate" value="${familyHead.birthdate}" />
</div>
</div>

<div class="form-group">
<label for="qualification">Edit Qualification</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="qualification" id="qualification" value="${familyHead.qualification1}" />
</div>
</div>

<div class="form-group">
<label for="profession">Edit Profession</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="profession" id="profession" value="${familyHead.profession}" />
</div>
</div>

<div class="form-group">
<label for="hobbies">Edit Hobbies</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="hobbies" id="hobbies" value="${familyHead.hobbies1}" />
</div>
</div>

<div class="form-group">
<label for="address">Edit Address</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="address" id="address" value="${familyHead.address}" />
</div>
</div>

<div class="form-group">
<label for="location">Edit Location</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="text" class="form-control" name="location" id="location" value="${familyHead.location}" />
</div>
</div>

<div class="form-group">
<label for="email">Edit Email</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="email" class="form-control" name="email" id="email" value="${familyHead.email}" />
</div>
</div>

<div class="form-group">
<label for="mobile">Edit Mobile Number</label>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
<input type="number" class="form-control" name="mobile" id="mobile" value="${familyHead.mobile}" />
</div>
</div>


<div class="form-group" align="center">
<button type="submit" class="btn btn-primary">Update</button>
</div>
</form>
</div><!--main-center"-->
</div><!--main-->
</div><!--container-->
</body>
</html>