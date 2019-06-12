import React from 'react';
import ReactDOM from 'react-dom'
import {Button, LocaleProvider} from 'antd-mobile';
import enUs from 'antd-mobile/lib/locale-provider/en_US';
//
import env from '@common/environments/environment';
//
import 'moment/locale/zh-cn';
import 'moment/locale/zh-hk';
//
import './index.less';

//
class App extends React.Component {
    test() {
        console.log(env.mode);
    };

    render() {
        return (
            <LocaleProvider locale={enUs}>
                <div style={{width: 400, margin: '100px auto'}}>
                    <Button onClick={() => this.test()}>A</Button>
                </div>
            </LocaleProvider>
        );
    }
}

ReactDOM.render(<App/>, document.getElementById('root'));
