"use strict"
var myApp = angular.module('myApp',[]);
myApp.controller('singleBusRegistrationController', singleBusRegistrationController);

function  singleBusRegistrationController($scope,$http){
$scope.singlebusreg={};
$scope.expansion1=true;
$scope.lisseats=[1,2,3];
$scope.lisbackseats=[0,1,2,3,4,5,6];
$scope.busdesign=false;
$scope.stoppagelis=[];
$scope.singlebusreg.lisstoppages=[];
$scope.basicdetails=false;
$scope.tripdetails=false;
$scope.stoppagedetails=false;

$scope.reset=function()
{
$scope.singlebusreg={};
$scope.expansion1=true;
$scope.busdesign=false;
$scope.singlebusreg.lisstoppages=[];
$scope.stoppagelis=[];
$scope.basicdetails=false;
$scope.tripdetails=false;
$scope.stoppagedetails=false;
}

$scope.expand=function(obj)
{
	if(obj=="basicdetail")
	{
		if($scope.expansion1==true)
		{
		$scope.expansion1=false;
		}
		else
		{
		$scope.expansion1=true;
		}
	}
}



$scope.seatclick=function()
{
$scope.singlebusreg.seatlastseat=null;
$scope.singlebusreg.seatleftside=null;
$scope.singlebusreg.seatrightside=null;
$scope.singlebusreg.rows=null;
$scope.busdesign=false;
}

$scope.validations=function(obj,val)
{
    if(obj=="name")
	{
	  if(val!=null && val!="")
	  {
		  for (let i = 0; i < val.length; i++)
		  {
		      if((val.charCodeAt(i)>=65 && val.charCodeAt(i)<=90)||(val.charCodeAt(i)>=97 && val.charCodeAt(i)<=122)||(val.charCodeAt(i)==32))
		      {
		      	continue;
		      }
		      else
		      {
		      	$scope.alert("Invalid Name");
		        $scope.singlebusreg.customername=null;
		      	break;
		      }
	      }
      }
	}
	else if(obj=="surname")
	{
	  if(val!=null && val!="")
	  {
		  for (let i = 0; i < val.length; i++)
		  {
		      if((val.charCodeAt(i)>=65 && val.charCodeAt(i)<=90)||(val.charCodeAt(i)>=97 && val.charCodeAt(i)<=122)||(val.charCodeAt(i)==32))
		      {
		      	continue;
		      }
		      else
		      {
		      	$scope.alert("Invalid SurName");
		        $scope.singlebusreg.customersurname=null;
		      	break;
		      }
	      }
      }
	}
	else if(obj=="tc")
	{
		  if(val!=null && val!="")
		  {
			  if((val.length>=12 && val.length<=10))
			  {
			  	$scope.alert("Invalid Tc");
			    $scope.singlebusreg.tcno=null;
			    return;
			  }
			  else
			  {
				continue;
			  }
			
			//   for (let i = 0; i < val.length; i++)
		    //   {
			//       if((val.charCodeAt(i)>=65 && val.charCodeAt(i)<=90)||(val.charCodeAt(i)>=48 && val.charCodeAt(i)<=57))
			//       {
			//       	continue;
			//       }
			//       else
			//       {
			//         $scope.alert("Invalid Bus Number Plate");
			//         $scope.singlebusreg.tcno=null;
			//       	return;
			//       }    
	        //   }
	       
	          $http({
			    method : "POST",
			      url : "checkusername",
			      data: val
			  }).then(function mySuccess(response) { 
			  if(response.data.status=="Failed")
			  {
			   $scope.alert(response.data.message);
			   $scope.singlebusreg.tcno=null;
			  }
			  }, function myError(response) {
			  $scope.alert("Something went wrong. Please Try Again Later.");
			  $scope.singlebusreg.tcno=null;
			  });
		  }
	}
	else if(obj=="mobile")
	{
		if($scope.singlebusreg.mobileno!=null)
		{
		      val= String(val);
		      if(val.length==10)
		      {
			      for (let i = 0; i < val.length; i++)
				  {
				      if((val.charCodeAt(i)>=48 && val.charCodeAt(i)<=57))
				      {
				      	continue;
				      }
				      else
				      {
				        $scope.alert("Invalid Mobile No");
				        $scope.singlebusreg.mobileno=null;
				      	break;
				      }
			      }
		      }
		      else
		      {
		         $scope.alert("Invalid Mobile No");
		     	 $scope.singlebusreg.mobileno=null;
		      }
		}
		else
		{
		 $scope.singlebusreg.mobileno=null;
		}
	}
	else if(obj=="email")
	{ 
		if(val!=null)
		{
		
		}
		else
		{
		    $scope.alert("Invalid EmailID");
			$scope.singlebusreg.emailid=null;
		}
	}


	}
	if(($scope.singlebusreg.customername!=null && $scope.singlebusreg.customername!="")&&($scope.singlebusreg.customersurname!=null && $scope.singlebusreg.customersurname!="")&&($scope.singlebusreg.tcno!=null && $scope.singlebusreg.tcno!="")&&($scope.singlebusreg.mobileno!=null)&&($scope.singlebusreg.emailid!=null))
	{
		$scope.basicdetails=true;
	}
	else
	{
		$scope.basicdetails=false;
	}
	
}


$scope.busregsubmit=function()
{
	if($scope.basicdetails==false)
	{
		$scope.alert("Please fill all details");
		return;
	}
	$http({
	method : "POST",
	//url : "customerregister",
	data: $scope.singlebusreg
	}).then(function mySuccess(response) { 
	if(response.data.status=="Failed")
	{
	$scope.alert(response.data.message);
	}
	else
	{
	$scope.alert(response.data.message);
	$scope.reset();
	}
	}, function myError(response) {
	$scope.alert("Something went wrong.Please try Again Later");
	});
}


