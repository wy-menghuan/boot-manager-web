app.controller('brandController', function($scope,$controller,brandService) {
	
	   $controller('baseController',{$scope:$scope});//继承
	
	
		//查询品牌列表
		$scope.findAll=function(){
			brandService.findAll().success(
				function(response){
					$scope.list=response;
				}		
			);				
		}
		
		
		
		//分页
		$scope.findPage=function(page,size){
			brandService.findPage(page,size).success(
					function(response){
						$scope.list=response.rows;//显示当前页数据 	
						$scope.paginationConf.totalItems=response.total;//更新总记录数 
					}
			
			);
		         
		}
		
		
		//$scope.entity={};
		//新增
		$scope.save=function(){
			var object=null;//方法名称
			var imgsUrl=$("#prodImgs").val();
			$scope.entity.bic=imgsUrl;
			if($scope.entity.id!=null){//如果有ID
				object=brandService.update($scope.entity);
			}else{
				object=brandService.add($scope.entity);
			}	
			object.success(
					function(response){
						if(response.success){
							   //重新查询 
					            $scope.reloadList();//重新加载
						}else{
							   alert(response.message);
						 }
					}		
			);				
	}
		
		//查询实体
		$scope.findOne=function(id){
			
			brandService.findOne(id).success(
					function(response){
						$scope.entity=response;
					}
			
			);
		}
		
		
		
		
		
		
		//删除
		$scope.dele=function(){
			brandService.dele($scope.selectIds).success(
				function(response){
					if(response.success){
						$scope.reloadList();//刷新
					}else{
						alert(response.message);
					}
				}
			
			
			);
		}
		
		$scope.searchEntity={};
		//条件查询
		$scope.search=function(page,size){
			brandService.search(page,size,$scope.searchEntity).success(
					function(response){
						$scope.list=response.rows;//显示当前页数据 	
						$scope.paginationConf.totalItems=response.total;//更新总记录数 
					}
			
			
			);
		}
		
		/*//上传图片
		$scope.uploadFile=function(){
			uploadService.uploadFile().success(
				function(response){
					if(response.success){
						$scope.image_entity.url= response.message;
					}else{
						alert(response.message);					
					}
				}		
			);
			
			
		}*/
		
		
		/*//上传图片
		$scope.uploadFile=function(){
			uploadService.uploadFile().success(
				function(response){
					if(response.success){
						$scope.imgurl=response.message;  
					}else{
						alert(response.message);	
					}
				}		
			);
			
			
		}*/
		
		
		
		
		
		
	}); 