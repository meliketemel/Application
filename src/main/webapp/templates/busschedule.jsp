<div data-ng-controller="customerSeatBookingController">
    <div style="background-color:#e7feff;" class="container">
        <h2 class="d-flex justify-content-center">Bus Schedule</h2><br><br>
        <form>
            <br>
            <div class="d-flex justify-content-center">
                <button type="button" ng-click="schedule()" class="btn btn-success">Tab to all list</button>
                &nbsp;
            </div>
        </form>
    </div>
    <br>
    <div ng-show="available" class="container" style="background-color:#e7feff;">
        <h2 class="d-flex justify-content-center">Available Buses</h2>
        <br>
        <div ng-show="resplis.length==0">
            <h3 class="d-flex justify-content-center">No bus available at this moment</h3>
            <br><br>
        </div>
        <div ng-show="resplis.length>0">
            <div data-ng-repeat="m in resplis" style="margin-left:10%">
                <h1 data-ng-click="expandbus(m,'expand')" class="verticaldtls">{{m.busdetails.busname}} |
                    {{m.startpoint}} -> {{m.endpoint}} | {{m.deptime}} - {{m.arrtime}} &nbsp;&nbsp;&nbsp;<i
                        class="fa fa-angle-down" ng-show="!m.expansion"></i><i class="fa fa-angle-up"
                        ng-show="m.expansion"></i></h1>
                <div ng-show="m.expansion">
                    <jsp:include page="busseatallocate.jsp" />
                </div>
            </div>
            <br><br>
        </div>
    </div>
</div>