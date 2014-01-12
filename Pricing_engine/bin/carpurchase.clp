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

;; gloval evaluation value
;; (defglobal ?*eval* = 0)


;; CAR DOMAIN TYPES

;; Family

(defrule door-number
	"Add rating for door-number"
	
	(UserRequest
		(carDomainType ?X&:(eq ?X (CarDomainType.FAMILY)))
	)
	(Car
		(doorCount ?Y&:(> ?Y 11))
	)
	(Car (OBJECT ?object-car))
	=>
	(add (new CarEvaluation ?object-car 1.0))
)




;; tests
(defrule append-all-cars-to-output
    "Test method that append all cars to output"
    (Car (brand ?X&:(eq ?X (CarBrand.FERRARI))))
    (Car (OBJECT ?object-car))
    =>
    (add (new CarEvaluation ?object-car 0.0))
)

(defrule doggie-approves-when-user-wants-luxurytor
	"Adds a string output when the user requests for a luxury car type"
	(UserRequest
		(carDomainType ?X&:(eq ?X (CarDomainType.LUXURY)))
	)
	=>
	(add "wow that luxury, such equalsh, much add!!!")
)
