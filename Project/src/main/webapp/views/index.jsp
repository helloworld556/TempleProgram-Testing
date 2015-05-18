<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en" ng-app="labApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>My AngularJS App</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/normalize.css">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/main.css">
    <link rel="stylesheet" href="app.css">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <script src="bower_components/html5-boilerplate/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-route/angular-route.js"></script>
    <script src="bower_components/angular-resource/angular-resource.js"></script>
    <script src="bower_components/angular-cookies/angular-cookies.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/ng-flow/dist/ng-flow-standalone.js"></script>

    <script src="app.js"></script>
    <script src="js/productController.js"></script>
    <script src="js/productService.js"></script>



    <!-- add i18n script -->
    <script src="bower_components/angular-translate/angular-translate.js"></script>
    <script src="bower_components/angular-translate-loader-url/angular-translate-loader-url.js"></script>
    <script src="js/languageServices.js"></script>
    <script src="js/languageControllers.js"></script>
    <script src="js/shoppingCartController.js"></script>
    <script src="js/shoppingCartService.js"></script>
    <script src="js/securityController.js"></script>
</head>

<div class="page-header">
    <h1 translate style="margin-left:450px;">listProduct.nameHead

    </h1>

</div>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>


        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" style="margin-left:350px;">

                <li class="active"><a href="#/history">History <span class="sr-only">(current)</span></a></li>

                <li class="active"><a href="#/listProduct">Activity <span class="sr-only">(current)</span></a></li>

                <li class="active"><a href="#/Chanting">Chanting <span class="sr-only">(current)</span></a></li>

                <li class="active"><a href="#/Donate">Donate <span class="sr-only">(current)</span></a></li>

                <li class="active"><a href="#/Q&A">Q&A <span class="sr-only">(current)</span></a></li>

                <li class="active"><a href="#/Contact US">Contact us <span class="sr-only">(current)</span></a></li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a  href="https://th-th.facebook.com/watphathammapirom"><img src = "pic/fb.png" width="50" height="50"></a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<div class="navbar navbar-default" ng-controller="languageController">
    <div class="container-fluid">
            <div class="collapse navbar-collapse">
                <div class="col-md-9 col-md-offset-2" ng-controller="loginController" >
                    <form class="form-inline" ng-hide="user" >
                        <div class="form-group ">
                            <label for="username" class="col-sm-3 control-label">User Name:</label>
                            <div class="col-sm-3">
                                <input id="username" ng-model="username" type="text" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">Password:</label>
                            <div class="col-sm-3">
                                <input id="password" ng-model="password" type="password" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-3 col-sm-offset-3">
                                <input type="submit" value="Log In" class="btn btn-primary" ng-click="login()"/>
                            </div>
                            <div class="col-sm-3 col-sm-offset-3">
                                <a class="btn btn-primary" href="#/register">Register</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <div>
                                <div class="checkbox">
                                    <label>
                                        <input style="margin-left:100px;" type="checkbox" ng-model="rememberMe"> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                    </form>
                    <form class="form-inline" ng-show="user" >
                        <div class="H6 col-sm-5 col-sm-offset-3 text-right">
                            Wellcame! {{user.name}}
                        </div>
                        <div class="form-group">
                            <div class="col-sm-3 ">
                                <input type="submit" value="Log Out" class="btn btn-primary" ng-click="logout(); emptyCart()"/>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="collapse navbar-collapse" ng-controller="languageController">
                <ul class="nav navbar-nav navbar-right">
                    <li ng-class="{'active':currentLocale== 'en'}"><a href="" ng-click="changeLanguage('en')">EN </a></li>
                    <li ng-class="{'active':currentLocale== 'fr'}"><a href="" ng-click="changeLanguage('fr')">TH</a></li>
                </ul>
            </div>
                </div>
    </div>
</div>
    <div class="container ng-hide" ng-show="initialized">
        <div class="alert alert-danger" ng-show="error">{{error}}</div>
    </div>

<div class="container-fluid">
    <div class="row">

        <div class="col-md-10">
            <!-- Breadcrumbs
           ================================================== -->


            <ng-view>Loading...</ng-view>

        </div>
    </div>
</div>


<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
-->

</body>
</html>
