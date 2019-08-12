import * as React from 'react';
import {inject, observer} from "mobx-react";
import DefaultLayout from "@/components/Layout/DefaultLayout";
import {Layout} from "antd";
//
import './UserCenterLayout.less';
import {withRouter} from "react-router";
//
const {Content, Sider} = Layout;

/**
 * 管理页面布局
 */
@inject('store')
@observer
class AdminLayout extends React.Component<any, any> {
    constructor(props: any) {
        super(props);
    }

    render() {
        const {children} = this.props;

        return (
            <DefaultLayout>
                <Layout className="user-center-layout">
                    <Sider width={200} style={{background: '#fff'}}>
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

export default withRouter(AdminLayout);
