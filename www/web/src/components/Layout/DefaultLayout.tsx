import * as React from 'react';
import {Avatar, Dropdown, Icon, Layout, Menu} from "antd";
import {inject, observer} from "mobx-react";
import * as intl from 'react-intl-universal';
//
import './DefaultLayout.less';
import {BaseProps, FormProps, RouteProps} from "@/types/props.interface";
import {Link} from "react-router-dom";
//
const {Content, Header, Footer} = Layout;

//
export interface DefaultLayoutProps extends FormProps, RouteProps, BaseProps {
}

/**
 * 站点布局
 */
@inject('store')
@observer
export default class DefaultLayout extends React.Component<DefaultLayoutProps, any> {
    state = {
        selectedKeys: ['1']
    };

    constructor(props: any) {
        super(props);
    }

    onMenuClick = async (item: any) => {
        if (item.key === 'logout') {
            await this.props.store.clear();
            this.props.history.push('/login');
        }
        if (item.key === 'change-password') {
            // this.showModal();
        }
    };

    render() {
        const {children, store} = this.props;
        const {selectedKeys} = this.state;

        const userMenu = (
            <Menu className="user-drowdown-menu" onClick={this.onMenuClick}>
                <Menu.Item className="user-drowdown-menu-item" key="account">
                    <Icon type="user"/>
                    <span className="user-drowdown-menu-label">
                    {intl.get('user_label_account')}
                    </span>
                </Menu.Item>
                <Menu.Item className="user-drowdown-menu-item" key="change-password">
                    <Icon type="lock"/>
                    <span className="user-drowdown-menu-label">
                    {intl.get('user_label_change_password')}
                    </span>
                </Menu.Item>
                <Menu.Item className="user-drowdown-menu-item" key="preferences">
                    <Icon type="setting"/>
                    <span className="user-drowdown-menu-label">
                    {intl.get('user_label_preferences')}
                    </span>
                </Menu.Item>
                <Menu.Divider/>
                <Menu.Item className="user-drowdown-menu-item" key="logout">
                    <Icon type="logout"/>
                    <span className="user-drowdown-menu-label">
                    {intl.get('label_logout')}
                    </span>
                </Menu.Item>
            </Menu>
        );

        return (
            <Layout className="layout page-layout">
                <Header className="page-header">
                    <div className="logo"/>

                    <Menu className="page-nav"
                          mode="horizontal"
                          style={{lineHeight: '64px'}}
                          defaultSelectedKeys={['1']}
                          selectedKeys={selectedKeys}>
                        <Menu.Item key="1">Home</Menu.Item>
                        <Menu.Item key="2">My Course</Menu.Item>
                    </Menu>

                    <div className="page-user-nav">
                        {store.authenticated ? (
                            <Dropdown overlay={userMenu} placement="bottomRight">
                                <span className="action account">
                                    <Avatar icon="user"/>
                                </span>
                            </Dropdown>
                        ) : (
                            <div>
                                <Link className="action" to="login">登录</Link>
                                <Link className="action" to="register">注册</Link>
                            </div>
                        )}
                    </div>
                </Header>

                <Content style={{padding: '0 50px'}}>
                    {children}
                </Content>

                <Footer className="page-footer">
                    LXP©2019
                </Footer>
            </Layout>
        );
    }
}
