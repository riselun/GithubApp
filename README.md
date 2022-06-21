###GithubApp
根据github api写的一个github客户端，时间非常紧，所以很多写得比较简陋，但是大体框架已经完成，后面可以补充详细

#### 注意事项：
要把local.properties 里面的CLIENT_ID和CLIENT_SECRET修改为你自己的；
#### 功能：
	1. 搜索Github仓库，按照星星从多到少排序
	2. 登陆
	3. 获得个人信息

#### 代码介绍：
* mvvm架构，使用koin库把逻辑分离，viewmodle实现ui数据同步，数据处理都在repository和datasource层， datasource主要是处理pager相关数据
* 图片库：外层做了简单的封装，暂时使用glide处理，后期把底层换成其他的；
* 用AndPermission简单做了权限获取处理；
* 关于登陆： 登陆之后会通过okhttp的拦截器自动在每个请求中header添加accesstoken；

