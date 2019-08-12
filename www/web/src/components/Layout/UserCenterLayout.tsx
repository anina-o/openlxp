import * as React from 'react';
import {inject, observer} from "mobx-react";
import {withRouter} from "react-router";
import {Layout, Menu} from "antd";
import DefaultLayout from "@/components/Layout/DefaultLayout";
//
import './UserCenterLayout.less';
//
const {Content, Sider} = Layout;

/**
 * 用户中心布局
 */
@inject('store')
@observer
class UserCenterLayout extends React.Component<any, any> {
    constructor(props: any) {
        super(props);
    }

    render() {
        const {children} = this.props;

        return (
            <DefaultLayout>
                <Layout className="user-center-layout">
                    <Sider width={200} style={{background: '#fff'}}>
                        <Menu mode="inline" style={{height: '100%'}}>
                            <Menu.Item key="user-center-account-key">option1</Menu.Item>
                            <Menu.Item key="user-center-change-password-key">option2</Menu.Item>
                        </Menu>
                    </Sider>
                    <Content className="user-center-content">
                        <div className="user-center-content-container">
                            {children}
                        </div>
                    </Content>
                </Layout>
            </DefaultLayout>
        );
    }
}

export default withRouter(UserCenterLayout);
