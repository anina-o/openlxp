import * as React from 'react';
import videojs from 'video.js'
//
import "./VJSPlayer.less";

/**
 * VJSPlayer
 *
 * https://videojs.com/
 */
export default class VJSPlayer extends React.Component<any, any> {
    /**
     * 原生的Video节点
     */
    videoNode: HTMLElement | null = null;
    /**
     * 播放器实例
     */
    player: videojs.Player | null = null;

    componentDidMount() {
        this.player = videojs(this.videoNode, this.props, () => {
            console.log('onPlayerReady');
        });
    }

    componentWillUnmount() {
        if (this.player) {
            this.player.dispose();
        }
    }

    render() {
        return (
            <div>
                <div data-vjs-player>
                    <video ref={node => this.videoNode = node}
                           className="video-js">
                    </video>
                </div>
            </div>
        );
    }
}
