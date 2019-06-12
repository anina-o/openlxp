import React from 'react';
import ReactDOM from 'react-dom'
import {Button, LocaleProvider} from 'antd';
//
import env from '@common/environments/environment';
//
import zhCN from 'antd/lib/locale-provider/zh_CN';
//
import 'moment/locale/zh-cn';
import 'moment/locale/zh-hk';
//
import './index.less';

//
class App extends React.Component<{}, {}> {
    test() {
        console.log(env.mode);
    };

    render() {
        return (
            <LocaleProvider locale={zhCN}>
                <div style={{width: 400, margin: '100px auto'}}>
                    <Button onClick={() => this.test()}>A</Button>
                </div>
            </LocaleProvider>
        );
    }
}

ReactDOM.render(<App/>, document.getElementById('root'));
