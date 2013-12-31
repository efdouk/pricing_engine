;; Bind templates with model classes

(import softcomputing.task2.carpurchase.model.*)

;; separate imports for enums

(import softcomputing.task2.carpurchase.model.CarBrand)
(import softcomputing.task2.carpurchase.model.CarDomainType)

;; define templates

(deftemplate UserRequest       (declare (from-class UserRequest)))
(deftemplate CarCriterion       (declare (from-class CarCriterion)))
(deftemplate Car       (declare (from-class Car)))
(deftemplate CarBrand   (declare (from-class CarBrand)))
(deftemplate CarFeature (declare (from-class CarFeature)))
(deftemplate CarType    (declare (from-class CarType)))
(deftemplate FuelType    (declare (from-class FuelType)))
(deftemplate Transmission    (declare (from-class Transmission)))

;; Simple method that get all cars from database and appends it to the result

(defrule append-all-cars-to-output
    "Test method that append all cars to output"
    =>
    (add Car)
)

(defrule doggie-approves-when-user-wants-luxury
	"Adds a string output when the user requests for a luxury car type"
	(UserRequest
		(carDomainType ?X&:(eq ?X (CarDomainType.LUXURY)))
	)
	=>
	(add "wow that luxury, such equalsh, much add!")
)