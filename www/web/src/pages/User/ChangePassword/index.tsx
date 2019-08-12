import * as React from 'react';
import {inject, observer} from "mobx-react";
//
import {BaseProps} from "@/types/props.interface";
import UserCenterLayout from "@/components/Layout/UserCenterLayout";

/**
 * AccountPageProps
 */
interface AccountPageProps extends BaseProps {
}

/**
 * 个人信息编辑页面
 */
@inject('store')
@observer
export default class ChangePasswordPage extends React.Component<AccountPageProps> {

    render() {
        return (
            <UserCenterLayout>
                Home
            </UserCenterLayout>
        );
    }

}
