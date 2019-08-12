import * as React from 'react';
import {inject, observer} from 'mobx-react';
import DefaultLayout from "@/components/Layout/DefaultLayout";
import {withRouter} from "react-router";
import {BaseProps, RouteProps} from "@/types/props.interface";
import {Tabs} from "antd";
import * as intl from "react-intl-universal";
//
const {TabPane} = Tabs;

//
interface MyCoursePageProps extends RouteProps, BaseProps {
}

/**
 * 我的课程页面
 */
@inject('store')
@observer
class MyCoursePage extends React.Component<MyCoursePageProps, any> {
    render() {
        return (
            <DefaultLayout>
                <Tabs defaultActiveKey="activity_created_by_me">
                    <TabPane tab={intl.get('activity_created_by_me')} key="activity_created_by_me">
                        Content of Tab Pane 1
                    </TabPane>
                    <TabPane tab={intl.get('activity_participated_in')} key="activity_participated_in">
                        Content of Tab Pane 2
                    </TabPane>
                </Tabs>
            </DefaultLayout>
        )
    }
}

export default withRouter(MyCoursePage);
