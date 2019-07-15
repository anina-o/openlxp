import * as React from 'react';
import {inject, observer} from "mobx-react";
//
import {BaseProps} from "@/types/props.interface";
import DefaultLayout from "@/components/Layout/DefaultLayout";

/**
 * HomePageProps
 */
export interface HomePageProps extends BaseProps {
}

/**
 * 首页
 */
@inject('store')
@observer
export default class HomePage extends React.Component<HomePageProps> {

    render() {
        return (
            <DefaultLayout>
                Home<br/>
                Home<br/>
                Home<br/>
                Home<br/>
                Home<br/>
                Home<br/>
                Home<br/>
                Home<br/>
            </DefaultLayout>
        );
    }

}
