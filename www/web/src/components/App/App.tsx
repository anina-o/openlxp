import * as React from 'react';
import * as intl from 'react-intl-universal';
import {hot} from 'react-hot-loader';
import {HashRouter as Router, Route, Switch} from 'react-router-dom';
import {Provider} from 'mobx-react';
import {ConfigProvider} from 'antd';
import Helmet from "react-helmet";
import zhCnProvider from 'antd/lib/locale-provider/zh_CN';
//
import {applicationLocales, defaultApplicationLocale} from "@common/constants";
import {setupAxios} from "@common/utils/request";
import store from '@/stores';
//
import HomePage from "@/pages/Home";
import LoginPage from "@/pages/User/Login";
import RegisterPage from "@/pages/User/Register";
import MyCoursePage from "@/pages/Course/MyCource";
import AccountPage from "@/pages/User/Acount";
import ChangePasswordPage from "@/pages/User/ChangePassword";
import DashboardPage from "@/pages/Admin/Dashboard";

//
setupAxios().then();

class App extends React.Component<any> {
    state = {
        initDone: false,
    };

    async componentDidMount() {
        // 多语言国际化初始化
        await intl.init({
            currentLocale: defaultApplicationLocale,
            locales: applicationLocales,
        });
        // 初始全局状态信息
        await store.init();
        //
        this.setState({initDone: true});
    }

    render() {
        return (
            this.state.initDone &&
            <Provider store={store}>
                <ConfigProvider locale={zhCnProvider}>
                    <div id="app-container">
                        <Helmet>
                            <title>React Application</title>
                        </Helmet>
                        <Router>
                            <Switch>
                                <Route exact path="/" component={HomePage}/>
                                <Route exact path="/login" component={LoginPage}/>
                                <Route exact path="/register" component={RegisterPage}/>
                                <Route exact path="/account" component={AccountPage}/>
                                <Route exact path="/change-password" component={ChangePasswordPage}/>
                                <Route exact path="/courses" component={HomePage}/>
                                <Route exact path="/my-course" component={MyCoursePage}/>
                                <Route exact path="/admin/dashboard" component={DashboardPage}/>
                            </Switch>
                        </Router>
                    </div>
                </ConfigProvider>
            </Provider>
        );
    }
}

export default hot(module)(App);
