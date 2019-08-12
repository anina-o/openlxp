import * as React from 'react';
import {inject, observer} from 'mobx-react';
import {withRouter} from "react-router";
import AdminLayout from "@/components/Layout/AdminLayout";

/**
 * 我的课程页面
 */
@inject('store')
@observer
class DashboardPage extends React.Component<any, any> {
    callback(key: any) {
        console.log(key);
    }

    render() {
        return (
            <AdminLayout>
                DashBoard
            </AdminLayout>
        )
    }
}

export default withRouter(DashboardPage);
