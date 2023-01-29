<div class="container" style="background-color:#e7feff;" data-ng-controller="singleBusRegistrationController">
  <h2 class="d-flex justify-content-center">Customer Registration</h2>
  <br>
  <form>
  
  <h1 data-ng-click="expand('basicdetail')" class="verticaltabs"><span class="glyphicon glyphicon-plus" ng-show="!expansion1"></span><span class="glyphicon glyphicon-minus" ng-show="expansion1"></span> Basic Details</h1><br>
  <div class="container" ng-show="expansion1">
	<div class="form-group">
      <label for="customername">Name</label>
      <input type="text" class="form-control" id="customername" placeholder="Enter your name" data-ng-model="singlebusreg.customername" ng-blur="validations('name',singlebusreg.customername)" style="width:97%;">
    </div>
    <div class="form-group">
      <label for="customersurname" >Surame</label>
      <input type="text" id="customersurname" placeholder="Enter your surname" data-ng-model="singlebusreg.customersurname" class="form-control" ng-blur="validations('surname',singlebusreg.customersurname)" style="width:97%;">
    </div>
    <div class="form-group">
      <label for="tcno">Tc No</label>
      <input type="text" class="form-control" id="tcno" placeholder="Enter your Tc" data-ng-model="singlebusreg.tcno" ng-blur="validations('tc',singlebusreg.tcno)" style="width:97%;">
    </div>
     <div class="form-group">
      <label for="mobileno">Mobile No</label>
      <input type="number" class="form-control" step="1" id="mobileno" data-ng-model="singlebusreg.mobileno" placeholder="Enter your mobile no" ng-blur="validations('mobile',singlebusreg.mobileno)" style="width:97%;">
    </div>
    <div class="form-group">
      <label for="emailid">Email</label>
      <input type="email" class="form-control" id="emailid" data-ng-model="singlebusreg.emailid" placeholder="Enter your email" ng-blur="validations('email',singlebusreg.emailid)" style="width:97%;">
    </div>
    <br>
   </div>
   
    <br>
    <div class="d-flex justify-content-center">
    <button type="button" ng-click="busregsubmit()" class="btn btn-success">Submit</button>
    &nbsp;
    <button type="button" ng-click="reset()" class="btn btn-success">Reset</button>
    </div>
  </form>
</div>