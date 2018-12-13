import UIKit
import app

class ViewController: UIViewController, SampleView, BaseView {
    private lazy var presenter: SamplePresenter = { SamplePresenter(
        uiContext: MainLoopDispatcher(),
        baseView: self,
        sampleView: self
        )
    }()
    @IBOutlet weak var label: UILabel!
   
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
        presenter.onDestroy()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.callSimpleApi()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
   
}
