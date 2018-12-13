//
//  UI.swift
//  iosApp
//
//  Created by Jun Tung Liew on 12/12/18.
//

import Foundation
import UIKit
import app

public class UI: Kotlinx_coroutines_core_nativeCoroutineDispatcher {
    override public func dispatch(context: KotlinCoroutineContext, block: Kotlinx_coroutines_core_nativeRunnable) {
        DispatchQueue.main.async {
            block.run()
        }
    }
}

