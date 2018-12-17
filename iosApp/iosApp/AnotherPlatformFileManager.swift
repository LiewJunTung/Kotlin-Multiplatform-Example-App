//
//  AnotherPlatformFileManager.swift
//  iosApp
//
//  Created by Jun Tung Liew on 14/12/18.
//

import Foundation
import app

@objc class AnotherPlatformFileManager: NSObject, SampleFileManager {
    func saveFile() {
        let file = "file.txt" //this is the file. we will write to and read from it
        let text = "some text lololol" //just a text
        
        if let dir = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first {
            let fileURL = dir.appendingPathComponent(file)
            //writing
            do {
                try text.write(to: fileURL, atomically: false, encoding: .utf8)
            }
            catch {/* error handling here */}
        }
    }
    
    func readFile() {
        let file = "file.txt" //this is the file. we will write to and read from it
        let text = "some text" //just a text
        
        if let dir = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first {
            let fileURL = dir.appendingPathComponent(file)
            //reading
            do {
                let text2 = try String(contentsOf: fileURL, encoding: .utf8)
                print(text2)
            }
            catch {/* error handling here */}
        }
    }
    
}
