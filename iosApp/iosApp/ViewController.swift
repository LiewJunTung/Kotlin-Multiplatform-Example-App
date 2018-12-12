import UIKit
import app

class ViewController: UIViewController, SampleView, BaseView {
    
    
    func showError(error: KotlinThrowable) {
        print(error.message)
    }
    
    func returnString(result: String) {
        label.text = result
        print(result)
    }
    
    override func viewWillAppear(_ animated: Bool) {
       
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print("helo")
        let presenter = SamplePresenter(
            uiContext: UI() as! KotlinCoroutineContext,
            baseView: self,
            sampleView: self
        )
        presenter.callSimpleApi()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
