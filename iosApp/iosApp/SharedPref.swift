//
//  SharedPref.swift
//  iosApp
//
//  Created by Jun Tung Liew on 17/12/18.
//

import UIKit
import Foundation
import app

class SharedPref: UIViewController, SharedPrefView {
    func getSavedString(savedString: String) {
        valueText.text = savedString
    }
    private lazy var presenter: SharedPrefPresenter = {
        SharedPrefPresenter(sharedPrefView: self)
    }()
    
    @IBOutlet weak var valueText: UILabel!
    @IBOutlet weak var valueTextField: UITextField!
    @IBAction func saveText(_ sender: Any) {
        presenter.saveString(text: valueTextField.text ?? "")
        presenter.retrieveSaveString()
    }
    
    override func viewDidLoad() {
        presenter.retrieveSaveString()
    }
}
