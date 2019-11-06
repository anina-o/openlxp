import * as React from 'react';
import * as intl from 'react-intl-universal';
import {inject, observer} from "mobx-react";
import {Dropdown, Icon, Layout, Menu} from "antd";
//
import './AdminLayout.less';
import {withRouter} from "react-router";
import {BaseProps, RouteProps} from "@web/types/props.interface";
//
const {Content, Sider, Header} = Layout;

//
export interface AdminLayoutProps extends RouteProps, BaseProps {
}

/**
 * 管理页面布局
 */
@inject('store')
@observer
class AdminLayout extends React.Component<AdminLayoutProps> {

    constructor(props : any) {
        super(props);
    }

    toggleSidebar = async () => {
        await this.props.store.toggleSidebar();
    };

    onMenuClick = async () => {
        // await this.store.toggleSidebar();
    };

    render() {
        const {children} = this.props;

        const userMenu = (
            <Menu className="drowdown-menu" onClick={this.onMenuClick}>
                <Menu.Item className="drowdown-menu-item" key="account">
                    <Icon type="user"/>
                    <span className="drowdown-menu-label">{intl.get('user_label_account')}</span>
                </Menu.Item>
                <Menu.Item className="drowdown-menu-item" key="change-password">
                    <Icon type="lock"/>
                    <span className="drowdown-menu-label">{intl.get('user_label_change_password')}</span>
                </Menu.Item>
                <Menu.Item className="drowdown-menu-item" key="preferences">
                    <Icon type="setting"/>
                    <span className="drowdown-menu-label">{intl.get('user_label_preferences')}</span>
                </Menu.Item>
                <Menu.Divider/>
                <Menu.Item className="drowdown-menu-item" key="logout">
                    <Icon type="logout"/>
                    <span className="drowdown-menu-label">{intl.get('label_logout')}</span>
                </Menu.Item>
            </Menu>
        );

        return (
            <Layout className="layout admin-layout">
                <Sider className="admin-layout-sider"
                       trigger={null} collapsible collapsed={this.props.store.preference.sidebar.collapsed}>
                    <div className="logo">
                        Admin Console
                    </div>

                    <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                        <Menu.Item key="1">
                            <Icon type="user"/>
                            <span>nav 1</span>
                        </Menu.Item>
                        <Menu.Item key="2">
                            <Icon type="video-camera"/>
                            <span>nav 2</span>
                        </Menu.Item>
                        <Menu.Item key="3">
                            <Icon type="upload"/>
                            <span>nav 3</span>
                        </Menu.Item>
                    </Menu>
                </Sider>
                <Layout className="admin-content-layout">
                    <Header className="admin-content-header">
                        <Icon className="admin-content-header-trigger"
                              type={'menu-unfold'}
                              onClick={this.toggleSidebar}
                        />
                        <div className="admin-content-header-nav">
                            <Dropdown overlay={userMenu} placement="bottomRight">
                                <span className="action account">
                                    <Icon className="avatar" type="user"/>
                                    <span className="name">Administrator</span>
                                </span>
                            </Dropdown>
                        </div>
                    </Header>
                    <Content>
                        <div className="admin-content-container">
                            {children}
                        </div>
                    </Content>
                </Layout>
            </Layout>
        );
    }
}

export default withRouter(AdminLayout);
