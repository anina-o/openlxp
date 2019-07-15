import React from 'react';
import ReactDOM from 'react-dom'
//
import 'moment/locale/zh-cn';
import 'moment/locale/zh-hk';
//
import App from "@/components/App";
//
import './index.less';

const render = () => {
    ReactDOM.render(
        <App/>,
        document.getElementById('app-root'),
    );
};

render();
