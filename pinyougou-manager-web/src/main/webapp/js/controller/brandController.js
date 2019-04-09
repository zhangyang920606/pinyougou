
app.controller('brandController',function ($scope,$controller,brandService) {

 $controller('baseController',{$scope:$scope});


 $scope.findAll=function () {
brandService.findAll().success(
function (json) {
$scope.list=json;
}
);
}



$scope.findPage=function (page,size) {
brandService.findPage(page,size).success(
function (json) {
$scope.list=json.rows;
$scope.paginationConf.totalItems=json.totle;
}
)

};


$scope.add=function(){
var object=null;
if($scope.entity.id!=null){
object=brandService.update($scope.entity)
}else {
object=brandService.add($scope.entity)
}
object.success(
function (json) {
if(json.success){
$scope.reloadList();
}else {
alert(json.message);
}
}

)
}


$scope.findOne=function (id) {
brandService.findOne(id).success(
function (json) {
$scope.entity=json;
}

)
}




$scope.dele=function () {
brandService.dele($scope.selectIds).success(
function (json) {
if(json.success){
$scope.reloadList();
}else {
alert(json.message);
}
}

)

}

$scope.searchEntity={};

$scope.search=function (page,size) {
brandService.search(page,size,$scope.searchEntity).success(
function (json) {
$scope.list=json.rows;
$scope.paginationConf.totalItems=json.totle;
}
)
}

})