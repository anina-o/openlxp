import * as React from 'react';
import * as intl from 'react-intl-universal';
import {Link, withRouter} from "react-router-dom";
import {Avatar, Dropdown, Icon, Layout, Menu} from "antd";
import {inject, observer} from "mobx-react";
//
import './DefaultLayout.less';
//
const {Content, Header, Footer} = Layout;

/**
 * 站点布局
 */
@inject("store")
@observer
class DefaultLayout extends React.Component<any, any> {
    state = {
        selectedKeys : ['menu-key-home']
    };

    constructor(props : any) {
        super(props);
    }

    onMenuClick = async (item : any) => {
        if (item.key === 'logout') {
            await this.props.store.clear();
            this.props.history.replace('/');
        } else if (item.key === 'account') {
            this.props.history.replace('/account');
        } else if (item.key === 'change-password') {
            this.props.history.replace('/change-password');
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

                    <Menu className="page-nav" mode="horizontal"
                          style={{lineHeight : '64px'}}
                          defaultSelectedKeys={['1']}
                          selectedKeys={selectedKeys}>
                        <Menu.Item key="menu-key-home">
                            <Link to='/'>Home</Link>
                        </Menu.Item>
                        <Menu.Item key="menu-key-classroom">
                            <Link to='/classroom'>Classroom</Link>
                        </Menu.Item>
                        <Menu.Item key="menu-key-course">
                            <Link to='/course'>Course</Link>
                        </Menu.Item>
                        {store.authenticated ? (
                            <Menu.Item key="menu-key-my-course">
                                <Link to='/my-course'>My Course</Link>
                            </Menu.Item>
                        ) : ([])}
                        <Menu.Item key="menu-key-admin">
                            <Link to='/admin/dashboard'>Admin</Link>
                        </Menu.Item>
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

                <Content className="page-content">
                    <div className="page-content-container">
                        {children}
                    </div>
                </Content>

                <Footer className="page-footer">
                    Copyright&copy;2019
                </Footer>
            </Layout>
        );
    }
}

export default withRouter(DefaultLayout);
