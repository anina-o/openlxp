import * as React from 'react';
import * as intl from 'react-intl-universal';
import {hot} from 'react-hot-loader';
import {HashRouter as Router, Route, Switch} from 'react-router-dom';
import {Provider} from 'mobx-react';
import {LocaleProvider} from 'antd';
import Helmet from "react-helmet";
import zhCnProvider from 'antd/lib/locale-provider/zh_CN';
//
import {applicationLocales, defaultApplicationLocale} from "@common/constants";
import store from '@/stores';
//
import HomePage from "@/pages/Home";

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
                <LocaleProvider locale={zhCnProvider}>
                    <div id="app-container">
                        <Helmet>
                            <title>React Application</title>
                        </Helmet>
                        <Router>
                            <Switch>
                                <Route exact path="/" component={HomePage}/>
                            </Switch>
                        </Router>
                    </div>
                </LocaleProvider>
            </Provider>
        );
    }
}

export default hot(module)(App);
