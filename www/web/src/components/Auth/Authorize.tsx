import * as React from 'react';
import {inject} from "mobx-react";

/**
 * 认证组件
 */
@inject('store')
export default class Authorize extends React.Component<any, any> {
    render() {
        const {store, children, authority, noMatch = null} = this.props;
        const render = typeof children === 'undefined' ? null : children;
        return store.hasPermission(authority) ? render : noMatch;
    }
}
